package com.katalon.testops.configuration;

import com.katalon.testops.helper.ParameterHelper;

import java.nio.file.Paths;

import static com.katalon.testops.core.Constants.*;

public class TestOpsConfigurationCreator implements ConfigurationCreator {
    @Override
    public Configuration createConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setServerUrl(ParameterHelper.getOrDefault(TESTOPS_SERVER_URL, TESTOPS_SERVER_URL_DEFAULT));
        configuration.setResultsDirectory(Paths.get(ParameterHelper.getOrDefault(TESTOPS_RESULTS_DIRECTORY, TESTOPS_RESULTS_DIRECTORY_DEFAULT)));
        configuration.setApiKey(ParameterHelper.get(TESTOPS_API_KEY));
        configuration.setProjectId(Long.valueOf(ParameterHelper.get(TESTOPS_PROJECT_ID)));
        return configuration;
    }
}
