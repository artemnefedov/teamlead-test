package ru.teamlead.jira.plugins.tutorial.rest;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import ru.teamlead.jira.plugins.tutorial.ao.StageItem;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/stage")
@AnonymousAllowed
public class StageRest {
    private final ActiveObjects ao;

    @Inject
    public StageRest(ActiveObjects ao) {
        this.ao = ao;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStages() {
        return Response.ok(
                Arrays.stream(ao.find(StageItem.class))
                        .map(stage -> {
                            Map<String, String> stageMap = new HashMap<>();
                            stageMap.put("num", String.valueOf(stage.getNum()));
                            stageMap.put("name", stage.getName());
                            return stageMap;
                        }).collect(Collectors.toList())
        ).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStage(StageItem stageItem) {
        StageItem newStage = ao.create(StageItem.class);
        newStage.setNum(stageItem.getNum());
        newStage.setName(stageItem.getName());
        newStage.save();
        return Response.ok().build();
    }
}
