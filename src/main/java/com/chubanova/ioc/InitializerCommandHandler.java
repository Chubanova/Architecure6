package com.chubanova.ioc;

import com.chubanova.Command;

public class  InitializerCommandHandler  implements Initializer<IoCDictionary<Command>> {
    @Override
    public void initialize(IoCDictionary<Command> handler) {
        handler.add("IoC.Register",
                RegisterCommand::new);

        handler.add("Scopes.New",
                CreateScopeCommand::new);

        handler.add("Scopes.Current",
                ChangeScopeCommand::new);

    }
}