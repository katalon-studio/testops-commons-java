package com.katalon.testops.core.web.api;

import com.katalon.testops.core.web.ApiClient;
import com.katalon.testops.core.web.model.ExecutionResource;
import com.katalon.testops.core.web.model.UploadBatchFileResource;
import com.katalon.testops.core.web.model.UploadBatchResource;
import com.katalon.testops.core.web.model.TestRunResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component("com.katalon.testops.api.TestReportApi")
public class TestReportApi {
    private ApiClient apiClient;

    public TestReportApi() {
        this(new ApiClient());
    }

    @Autowired
    public TestReportApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Saves and processes multiple uploaded Katalon reports.
     *
     * <p><b>200</b> - OK
     * @param body The body parameter
     * @param projectId The projectId parameter
     * @param batch The batch parameter
     * @return List&lt;UploadBatchResource&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<UploadBatchResource> processMultipleS3File(List<UploadBatchFileResource> body, Long projectId, String batch) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling processMultipleS3File");
        }
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectId' when calling processMultipleS3File");
        }
        // verify the required parameter 'batch' is set
        if (batch == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'batch' when calling processMultipleS3File");
        }
        String path = UriComponentsBuilder.fromPath("/api/v1/katalon/test-reports/multiple").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "projectId", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "batch", batch));

        final String[] accepts = {
            "*/*"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
            "application/json"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicScheme" };

        ParameterizedTypeReference<List<UploadBatchResource>> returnType = new ParameterizedTypeReference<List<UploadBatchResource>>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Saves and processes the uploaded Katalon reports.
     *
     * <p><b>200</b> - OK
     * @param projectId The projectId parameter
     * @param batch The batch parameter
     * @param folderPath The folderPath parameter
     * @param isEnd The isEnd parameter
     * @param fileName The fileName parameter
     * @param uploadedPath The uploadedPath parameter
     * @return List&lt;UploadBatchResource&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<UploadBatchResource> processS3File(String projectId, String batch, String folderPath, String isEnd, String fileName, String uploadedPath) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectId' when calling processS3File");
        }
        // verify the required parameter 'batch' is set
        if (batch == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'batch' when calling processS3File");
        }
        // verify the required parameter 'folderPath' is set
        if (folderPath == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'folderPath' when calling processS3File");
        }
        // verify the required parameter 'isEnd' is set
        if (isEnd == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'isEnd' when calling processS3File");
        }
        // verify the required parameter 'fileName' is set
        if (fileName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'fileName' when calling processS3File");
        }
        // verify the required parameter 'uploadedPath' is set
        if (uploadedPath == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'uploadedPath' when calling processS3File");
        }
        String path = UriComponentsBuilder.fromPath("/api/v1/katalon/test-reports").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "projectId", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "batch", batch));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "folderPath", folderPath));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isEnd", isEnd));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fileName", fileName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "uploadedPath", uploadedPath));

        final String[] accepts = {
            "*/*"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicScheme" };

        ParameterizedTypeReference<List<UploadBatchResource>> returnType = new ParameterizedTypeReference<List<UploadBatchResource>>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Saves and processes multiple uploaded TestOps reports.
     *
     * <p><b>200</b> - OK
     * @param body The body parameter
     * @param projectId The projectId parameter
     * @param batch The batch parameter
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void processTestOpsReports(List<UploadBatchFileResource> body, Long projectId, String batch) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling processTestOpsReports");
        }
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectId' when calling processTestOpsReports");
        }
        // verify the required parameter 'batch' is set
        if (batch == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'batch' when calling processTestOpsReports");
        }
        String path = UriComponentsBuilder.fromPath("/api/v1/testops-reports").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "projectId", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "batch", batch));

        final String[] accepts = {  };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
            "application/json"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicScheme" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     *
     *
     * <p><b>200</b> - OK
     * @param body The body parameter
     * @param projectId The projectId parameter
     * @return ExecutionResource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ExecutionResource updateResult(TestRunResult body, Long projectId) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling updateResult");
        }
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectId' when calling updateResult");
        }
        String path = UriComponentsBuilder.fromPath("/api/v1/katalon/test-reports/update-result").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "projectId", projectId));

        final String[] accepts = {
            "*/*"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
            "application/json"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicScheme" };

        ParameterizedTypeReference<ExecutionResource> returnType = new ParameterizedTypeReference<ExecutionResource>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Uploads and processes the JUnit reports to an Execution.
     *
     * <p><b>204</b> - No Content
     * @param projectId The projectId parameter
     * @param batch The batch parameter
     * @param folderPath The folderPath parameter
     * @param isEnd The isEnd parameter
     * @param fileName The fileName parameter
     * @param uploadedPath The uploadedPath parameter
     * @param sessionId The sessionId parameter
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void uploadJUnitReports(String projectId, String batch, String folderPath, String isEnd, String fileName, String uploadedPath, String sessionId) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectId' when calling uploadJUnitReports");
        }
        // verify the required parameter 'batch' is set
        if (batch == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'batch' when calling uploadJUnitReports");
        }
        // verify the required parameter 'folderPath' is set
        if (folderPath == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'folderPath' when calling uploadJUnitReports");
        }
        // verify the required parameter 'isEnd' is set
        if (isEnd == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'isEnd' when calling uploadJUnitReports");
        }
        // verify the required parameter 'fileName' is set
        if (fileName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'fileName' when calling uploadJUnitReports");
        }
        // verify the required parameter 'uploadedPath' is set
        if (uploadedPath == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'uploadedPath' when calling uploadJUnitReports");
        }
        String path = UriComponentsBuilder.fromPath("/api/v1/junit/test-reports").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "projectId", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "batch", batch));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "folderPath", folderPath));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isEnd", isEnd));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fileName", fileName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "uploadedPath", uploadedPath));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "sessionId", sessionId));

        final String[] accepts = {  };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicScheme" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Uploads and processes the TestNG reports to an execution.
     *
     * <p><b>204</b> - No Content
     * @param executionId The executionId parameter
     * @param projectId The projectId parameter
     * @param batch The batch parameter
     * @param folderPath The folderPath parameter
     * @param isEnd The isEnd parameter
     * @param fileName The fileName parameter
     * @param uploadedPath The uploadedPath parameter
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void uploadTestNGReports(Long executionId, Long projectId, String batch, String folderPath, Boolean isEnd, String fileName, String uploadedPath) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'executionId' is set
        if (executionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'executionId' when calling uploadTestNGReports");
        }
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'projectId' when calling uploadTestNGReports");
        }
        // verify the required parameter 'batch' is set
        if (batch == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'batch' when calling uploadTestNGReports");
        }
        // verify the required parameter 'folderPath' is set
        if (folderPath == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'folderPath' when calling uploadTestNGReports");
        }
        // verify the required parameter 'isEnd' is set
        if (isEnd == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'isEnd' when calling uploadTestNGReports");
        }
        // verify the required parameter 'fileName' is set
        if (fileName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'fileName' when calling uploadTestNGReports");
        }
        // verify the required parameter 'uploadedPath' is set
        if (uploadedPath == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'uploadedPath' when calling uploadTestNGReports");
        }
        String path = UriComponentsBuilder.fromPath("/api/v1/testng/test-reports").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "executionId", executionId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "projectId", projectId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "batch", batch));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "folderPath", folderPath));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isEnd", isEnd));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fileName", fileName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "uploadedPath", uploadedPath));

        final String[] accepts = {  };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicScheme" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
