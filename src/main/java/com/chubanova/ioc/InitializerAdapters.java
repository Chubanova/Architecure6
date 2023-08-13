package com.chubanova.ioc;



import com.chubanova.UObject;
import com.chubanova.adapter.*;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class InitializerAdapters implements Initializer<IoCDictionary<Adapter>> {
    private static final String ADAPTER_POSTFIX = "Adapter";
    private static final String ADAPTER_PACKAGE = "com.chubanova.adapter.impl.";
    private static final UObject uObj = UObjectImpl.getInstanse();

    private static final Map<Class<? extends Adapter>, UObject> ADAPTERS_FOR_INITIALIZE = Map.of(
        Generateable.class, uObj, Compilable.class, uObj, Loadable.class, uObj, Registrable.class, uObj);

    @Override
    public void initialize(IoCDictionary<Adapter> handler) {
        for (Class<? extends Adapter> aClass : ADAPTERS_FOR_INITIALIZE.keySet()) {
            

            Object adaptee = ADAPTERS_FOR_INITIALIZE.get(aClass);
            String adapterName = aClass.getSimpleName() + ADAPTER_POSTFIX;
            String adapteeName = adaptee.getClass().getSimpleName();
            String adapterAndAdapteeName = adapterName + "." + adapteeName;

            handler.add(
                    adapterAndAdapteeName,
                    (args) -> {
                        try {
                            Class clazzAdapter = Class.forName(ADAPTER_PACKAGE + adapterName);
                            Constructor constructor = clazzAdapter.getConstructor(UObject.class);
                            return (Adapter) constructor.newInstance(adaptee);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
            );
        }
    }
}
