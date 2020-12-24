package com.katalon.testops.commons.configuration;

import com.katalon.testops.commons.helper.ParameterHelper;

import java.nio.file.Paths;

import static com.katalon.testops.commons.core.Constants.*;

public class TestOpsConfigurationCreator implements ConfigurationCreator {

    @Override
    public Configuration createConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setServerUrl(ParameterHelper.getOrDefaultIfBlank(TESTOPS_SERVER_URL, TESTOPS_SERVER_URL_DEFAULT));
        configuration.setReportFolder(Paths.get(ParameterHelper.getOrDefaultIfBlank(TESTOPS_REPORT_DIRECTORY, TESTOPS_REPORT_DIRECTORY_DEFAULT)));
        configuration.setApiKey(ParameterHelper.get(TESTOPS_API_KEY));
        configuration.setBuildLabel(ParameterHelper.get(TESTOPS_BUILD_LABEL));
        configuration.setBuildUrl(ParameterHelper.get(TESTOPS_BUILD_URL));
        String projectId = ParameterHelper.getOrDefaultIfBlank(TESTOPS_PROJECT_ID, null);
        if (projectId != null) {
            configuration.setProjectId(Long.valueOf(projectId.trim()));
        }
        return configuration;
    }
}
