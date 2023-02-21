package net.cbarker.FreeTimeHelper.Core;

import net.cbarker.FreeTimeHelper.Activities.GenericActivityPrompt;

import java.util.List;

public class FreeTimeHelperEngineImplementation implements FreeTimeHelperEngine {

    @Override
    public List<Prompt> getPrompts(int promptCount) {
        return List.of(new GenericActivityPrompt("Go climbing"));
    }
}
