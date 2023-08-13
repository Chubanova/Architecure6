package com.chubanova.ioc;

import com.chubanova.Command;
import com.chubanova.UObject;
import com.chubanova.adapter.Adapter;
import com.chubanova.adapter.Registrable;
import lombok.RequiredArgsConstructor;


import java.lang.reflect.Constructor;

@RequiredArgsConstructor
public class RegisterAdapterCommand implements Command {
    private static final UObject uObject = UObjectImpl.getInstanse();
    private final Registrable registrable;
    private final Object[] classes;

    @Override
    public void execute() {
        Class clazz = (Class) classes[0];
        IoCDictionary<Adapter> handler = ScopeDictionaryImpl.getInstance().getCurrentScope();

        String registerAdapterName = registerAdapter(clazz, handler);

        registrable.setRegisterNames(
                new Object[]{
                        registerAdapterName
                }
        );
    }

    private String registerAdapter(Class clazzAdapter, IoCDictionary<Adapter> handler) {
        String adapterAndAdapteeName = clazzAdapter.getSimpleName() + "." + uObject.getClass().getSimpleName();

        handler.add(
                adapterAndAdapteeName,
                (args) -> {
                    try {
                        Constructor constructor = clazzAdapter.getConstructor(uObject.getClass());
                        return (Adapter) constructor.newInstance(uObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
        );

        return adapterAndAdapteeName;
    }
}
