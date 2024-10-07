package ru.teamlead.jira.plugins.tutorial.context;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.jira.plugin.webfragment.contextproviders.AbstractJiraContextProvider;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;
import com.atlassian.jira.user.ApplicationUser;
import ru.teamlead.jira.plugins.tutorial.ao.StageItem;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class StageDropdownContext extends AbstractJiraContextProvider {

    private final ActiveObjects ao;

    @Inject
    public StageDropdownContext(ActiveObjects ao) {
        this.ao = ao;
    }

    @Override
    public Map<String, StageItemDto[]> getContextMap(ApplicationUser applicationUser, JiraHelper jiraHelper) {
        return Collections.singletonMap("stages",
                                        Arrays.stream(ao.find(StageItem.class))
                                              .map(item -> new StageItemDto(item.getNum(), item.getName()))
                                              .toArray(StageItemDto[]::new)
        );
    }

    public static class StageItemDto {
        private int num;
        private String name;

        public StageItemDto() {
        }

        public StageItemDto(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public String getName() {
            return name;
        }


    }
}
