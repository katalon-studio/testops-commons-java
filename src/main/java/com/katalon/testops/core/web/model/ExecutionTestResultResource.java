/*
 * Katalon TestOps API reference
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.katalon.testops.core.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ExecutionTestResultResource
 */


public class ExecutionTestResultResource {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("testCase")
  private TestCaseResource testCase = null;

  @JsonProperty("execution")
  private ExecutionResource execution = null;

  @JsonProperty("platform")
  private PlatformResource platform = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PASSED("PASSED"),
    FAILED("FAILED"),
    ERROR("ERROR"),
    INCOMPLETE("INCOMPLETE"),
    RUNNING("RUNNING"),
    SKIPPED("SKIPPED"),
    NOT_RUN("NOT_RUN");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("sameStatusPeriod")
  private Long sameStatusPeriod = null;

  @JsonProperty("errorDetailsId")
  private Long errorDetailsId = null;

  @JsonProperty("stdoutId")
  private Long stdoutId = null;

  @JsonProperty("descriptionId")
  private Long descriptionId = null;

  @JsonProperty("logId")
  private Long logId = null;

  @JsonProperty("attachments")
  private List<FileResource> attachments = null;

  @JsonProperty("startTime")
  private OffsetDateTime startTime = null;

  @JsonProperty("endTime")
  private OffsetDateTime endTime = null;

  @JsonProperty("duration")
  private Long duration = null;

  @JsonProperty("sameFailureResults")
  private List<ExecutionTestResultIdentifyResource> sameFailureResults = null;

  @JsonProperty("testSuite")
  private TestSuiteResource testSuite = null;

  @JsonProperty("executionTestSuite")
  private ExecutionTestSuiteResource executionTestSuite = null;

  @JsonProperty("incidents")
  private List<IncidentResource> incidents = null;

  @JsonProperty("profile")
  private String profile = null;

  @JsonProperty("hasComment")
  private Boolean hasComment = null;

  @JsonProperty("errorMessage")
  private String errorMessage = null;

  @JsonProperty("errorDetail")
  private String errorDetail = null;

  @JsonProperty("webUrl")
  private String webUrl = null;

  @JsonProperty("externalIssues")
  private List<ExternalIssueResource> externalIssues = null;

  /**
   * Gets or Sets failedTestResultCategory
   */
  public enum FailedTestResultCategoryEnum {
    APPLICATION("APPLICATION"),
    AUTOMATION("AUTOMATION"),
    ENVIRONMENT("ENVIRONMENT"),
    UNKNOWN("UNKNOWN");

    private String value;

    FailedTestResultCategoryEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static FailedTestResultCategoryEnum fromValue(String text) {
      for (FailedTestResultCategoryEnum b : FailedTestResultCategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("failedTestResultCategory")
  private FailedTestResultCategoryEnum failedTestResultCategory = null;

  @JsonProperty("totalTestObject")
  private Long totalTestObject = null;

  @JsonProperty("totalDefects")
  private Integer totalDefects = null;

  @JsonProperty("urlId")
  private String urlId = null;

  public ExecutionTestResultResource id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ExecutionTestResultResource testCase(TestCaseResource testCase) {
    this.testCase = testCase;
    return this;
  }

   /**
   * Get testCase
   * @return testCase
  **/
  @Schema(description = "")
  public TestCaseResource getTestCase() {
    return testCase;
  }

  public void setTestCase(TestCaseResource testCase) {
    this.testCase = testCase;
  }

  public ExecutionTestResultResource execution(ExecutionResource execution) {
    this.execution = execution;
    return this;
  }

   /**
   * Get execution
   * @return execution
  **/
  @Schema(description = "")
  public ExecutionResource getExecution() {
    return execution;
  }

  public void setExecution(ExecutionResource execution) {
    this.execution = execution;
  }

  public ExecutionTestResultResource platform(PlatformResource platform) {
    this.platform = platform;
    return this;
  }

   /**
   * Get platform
   * @return platform
  **/
  @Schema(description = "")
  public PlatformResource getPlatform() {
    return platform;
  }

  public void setPlatform(PlatformResource platform) {
    this.platform = platform;
  }

  public ExecutionTestResultResource status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Schema(description = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ExecutionTestResultResource sameStatusPeriod(Long sameStatusPeriod) {
    this.sameStatusPeriod = sameStatusPeriod;
    return this;
  }

   /**
   * Get sameStatusPeriod
   * @return sameStatusPeriod
  **/
  @Schema(description = "")
  public Long getSameStatusPeriod() {
    return sameStatusPeriod;
  }

  public void setSameStatusPeriod(Long sameStatusPeriod) {
    this.sameStatusPeriod = sameStatusPeriod;
  }

  public ExecutionTestResultResource errorDetailsId(Long errorDetailsId) {
    this.errorDetailsId = errorDetailsId;
    return this;
  }

   /**
   * Get errorDetailsId
   * @return errorDetailsId
  **/
  @Schema(description = "")
  public Long getErrorDetailsId() {
    return errorDetailsId;
  }

  public void setErrorDetailsId(Long errorDetailsId) {
    this.errorDetailsId = errorDetailsId;
  }

  public ExecutionTestResultResource stdoutId(Long stdoutId) {
    this.stdoutId = stdoutId;
    return this;
  }

   /**
   * Get stdoutId
   * @return stdoutId
  **/
  @Schema(description = "")
  public Long getStdoutId() {
    return stdoutId;
  }

  public void setStdoutId(Long stdoutId) {
    this.stdoutId = stdoutId;
  }

  public ExecutionTestResultResource descriptionId(Long descriptionId) {
    this.descriptionId = descriptionId;
    return this;
  }

   /**
   * Get descriptionId
   * @return descriptionId
  **/
  @Schema(description = "")
  public Long getDescriptionId() {
    return descriptionId;
  }

  public void setDescriptionId(Long descriptionId) {
    this.descriptionId = descriptionId;
  }

  public ExecutionTestResultResource logId(Long logId) {
    this.logId = logId;
    return this;
  }

   /**
   * Get logId
   * @return logId
  **/
  @Schema(description = "")
  public Long getLogId() {
    return logId;
  }

  public void setLogId(Long logId) {
    this.logId = logId;
  }

  public ExecutionTestResultResource attachments(List<FileResource> attachments) {
    this.attachments = attachments;
    return this;
  }

  public ExecutionTestResultResource addAttachmentsItem(FileResource attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<FileResource>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

   /**
   * Get attachments
   * @return attachments
  **/
  @Schema(description = "")
  public List<FileResource> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<FileResource> attachments) {
    this.attachments = attachments;
  }

  public ExecutionTestResultResource startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @Schema(description = "")
  public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public ExecutionTestResultResource endTime(OffsetDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
   * Get endTime
   * @return endTime
  **/
  @Schema(description = "")
  public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }

  public ExecutionTestResultResource duration(Long duration) {
    this.duration = duration;
    return this;
  }

   /**
   * Get duration
   * @return duration
  **/
  @Schema(description = "")
  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public ExecutionTestResultResource sameFailureResults(List<ExecutionTestResultIdentifyResource> sameFailureResults) {
    this.sameFailureResults = sameFailureResults;
    return this;
  }

  public ExecutionTestResultResource addSameFailureResultsItem(ExecutionTestResultIdentifyResource sameFailureResultsItem) {
    if (this.sameFailureResults == null) {
      this.sameFailureResults = new ArrayList<ExecutionTestResultIdentifyResource>();
    }
    this.sameFailureResults.add(sameFailureResultsItem);
    return this;
  }

   /**
   * Get sameFailureResults
   * @return sameFailureResults
  **/
  @Schema(description = "")
  public List<ExecutionTestResultIdentifyResource> getSameFailureResults() {
    return sameFailureResults;
  }

  public void setSameFailureResults(List<ExecutionTestResultIdentifyResource> sameFailureResults) {
    this.sameFailureResults = sameFailureResults;
  }

  public ExecutionTestResultResource testSuite(TestSuiteResource testSuite) {
    this.testSuite = testSuite;
    return this;
  }

   /**
   * Get testSuite
   * @return testSuite
  **/
  @Schema(description = "")
  public TestSuiteResource getTestSuite() {
    return testSuite;
  }

  public void setTestSuite(TestSuiteResource testSuite) {
    this.testSuite = testSuite;
  }

  public ExecutionTestResultResource executionTestSuite(ExecutionTestSuiteResource executionTestSuite) {
    this.executionTestSuite = executionTestSuite;
    return this;
  }

   /**
   * Get executionTestSuite
   * @return executionTestSuite
  **/
  @Schema(description = "")
  public ExecutionTestSuiteResource getExecutionTestSuite() {
    return executionTestSuite;
  }

  public void setExecutionTestSuite(ExecutionTestSuiteResource executionTestSuite) {
    this.executionTestSuite = executionTestSuite;
  }

  public ExecutionTestResultResource incidents(List<IncidentResource> incidents) {
    this.incidents = incidents;
    return this;
  }

  public ExecutionTestResultResource addIncidentsItem(IncidentResource incidentsItem) {
    if (this.incidents == null) {
      this.incidents = new ArrayList<IncidentResource>();
    }
    this.incidents.add(incidentsItem);
    return this;
  }

   /**
   * Get incidents
   * @return incidents
  **/
  @Schema(description = "")
  public List<IncidentResource> getIncidents() {
    return incidents;
  }

  public void setIncidents(List<IncidentResource> incidents) {
    this.incidents = incidents;
  }

  public ExecutionTestResultResource profile(String profile) {
    this.profile = profile;
    return this;
  }

   /**
   * Get profile
   * @return profile
  **/
  @Schema(description = "")
  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public ExecutionTestResultResource hasComment(Boolean hasComment) {
    this.hasComment = hasComment;
    return this;
  }

   /**
   * Get hasComment
   * @return hasComment
  **/
  @Schema(description = "")
  public Boolean isHasComment() {
    return hasComment;
  }

  public void setHasComment(Boolean hasComment) {
    this.hasComment = hasComment;
  }

  public ExecutionTestResultResource errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

   /**
   * Get errorMessage
   * @return errorMessage
  **/
  @Schema(description = "")
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public ExecutionTestResultResource errorDetail(String errorDetail) {
    this.errorDetail = errorDetail;
    return this;
  }

   /**
   * Get errorDetail
   * @return errorDetail
  **/
  @Schema(description = "")
  public String getErrorDetail() {
    return errorDetail;
  }

  public void setErrorDetail(String errorDetail) {
    this.errorDetail = errorDetail;
  }

  public ExecutionTestResultResource webUrl(String webUrl) {
    this.webUrl = webUrl;
    return this;
  }

   /**
   * Get webUrl
   * @return webUrl
  **/
  @Schema(description = "")
  public String getWebUrl() {
    return webUrl;
  }

  public void setWebUrl(String webUrl) {
    this.webUrl = webUrl;
  }

  public ExecutionTestResultResource externalIssues(List<ExternalIssueResource> externalIssues) {
    this.externalIssues = externalIssues;
    return this;
  }

  public ExecutionTestResultResource addExternalIssuesItem(ExternalIssueResource externalIssuesItem) {
    if (this.externalIssues == null) {
      this.externalIssues = new ArrayList<ExternalIssueResource>();
    }
    this.externalIssues.add(externalIssuesItem);
    return this;
  }

   /**
   * Get externalIssues
   * @return externalIssues
  **/
  @Schema(description = "")
  public List<ExternalIssueResource> getExternalIssues() {
    return externalIssues;
  }

  public void setExternalIssues(List<ExternalIssueResource> externalIssues) {
    this.externalIssues = externalIssues;
  }

  public ExecutionTestResultResource failedTestResultCategory(FailedTestResultCategoryEnum failedTestResultCategory) {
    this.failedTestResultCategory = failedTestResultCategory;
    return this;
  }

   /**
   * Get failedTestResultCategory
   * @return failedTestResultCategory
  **/
  @Schema(description = "")
  public FailedTestResultCategoryEnum getFailedTestResultCategory() {
    return failedTestResultCategory;
  }

  public void setFailedTestResultCategory(FailedTestResultCategoryEnum failedTestResultCategory) {
    this.failedTestResultCategory = failedTestResultCategory;
  }

  public ExecutionTestResultResource totalTestObject(Long totalTestObject) {
    this.totalTestObject = totalTestObject;
    return this;
  }

   /**
   * Get totalTestObject
   * @return totalTestObject
  **/
  @Schema(description = "")
  public Long getTotalTestObject() {
    return totalTestObject;
  }

  public void setTotalTestObject(Long totalTestObject) {
    this.totalTestObject = totalTestObject;
  }

  public ExecutionTestResultResource totalDefects(Integer totalDefects) {
    this.totalDefects = totalDefects;
    return this;
  }

   /**
   * Get totalDefects
   * @return totalDefects
  **/
  @Schema(description = "")
  public Integer getTotalDefects() {
    return totalDefects;
  }

  public void setTotalDefects(Integer totalDefects) {
    this.totalDefects = totalDefects;
  }

  public ExecutionTestResultResource urlId(String urlId) {
    this.urlId = urlId;
    return this;
  }

   /**
   * Get urlId
   * @return urlId
  **/
  @Schema(description = "")
  public String getUrlId() {
    return urlId;
  }

  public void setUrlId(String urlId) {
    this.urlId = urlId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExecutionTestResultResource executionTestResultResource = (ExecutionTestResultResource) o;
    return Objects.equals(this.id, executionTestResultResource.id) &&
        Objects.equals(this.testCase, executionTestResultResource.testCase) &&
        Objects.equals(this.execution, executionTestResultResource.execution) &&
        Objects.equals(this.platform, executionTestResultResource.platform) &&
        Objects.equals(this.status, executionTestResultResource.status) &&
        Objects.equals(this.sameStatusPeriod, executionTestResultResource.sameStatusPeriod) &&
        Objects.equals(this.errorDetailsId, executionTestResultResource.errorDetailsId) &&
        Objects.equals(this.stdoutId, executionTestResultResource.stdoutId) &&
        Objects.equals(this.descriptionId, executionTestResultResource.descriptionId) &&
        Objects.equals(this.logId, executionTestResultResource.logId) &&
        Objects.equals(this.attachments, executionTestResultResource.attachments) &&
        Objects.equals(this.startTime, executionTestResultResource.startTime) &&
        Objects.equals(this.endTime, executionTestResultResource.endTime) &&
        Objects.equals(this.duration, executionTestResultResource.duration) &&
        Objects.equals(this.sameFailureResults, executionTestResultResource.sameFailureResults) &&
        Objects.equals(this.testSuite, executionTestResultResource.testSuite) &&
        Objects.equals(this.executionTestSuite, executionTestResultResource.executionTestSuite) &&
        Objects.equals(this.incidents, executionTestResultResource.incidents) &&
        Objects.equals(this.profile, executionTestResultResource.profile) &&
        Objects.equals(this.hasComment, executionTestResultResource.hasComment) &&
        Objects.equals(this.errorMessage, executionTestResultResource.errorMessage) &&
        Objects.equals(this.errorDetail, executionTestResultResource.errorDetail) &&
        Objects.equals(this.webUrl, executionTestResultResource.webUrl) &&
        Objects.equals(this.externalIssues, executionTestResultResource.externalIssues) &&
        Objects.equals(this.failedTestResultCategory, executionTestResultResource.failedTestResultCategory) &&
        Objects.equals(this.totalTestObject, executionTestResultResource.totalTestObject) &&
        Objects.equals(this.totalDefects, executionTestResultResource.totalDefects) &&
        Objects.equals(this.urlId, executionTestResultResource.urlId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, testCase, execution, platform, status, sameStatusPeriod, errorDetailsId, stdoutId, descriptionId, logId, attachments, startTime, endTime, duration, sameFailureResults, testSuite, executionTestSuite, incidents, profile, hasComment, errorMessage, errorDetail, webUrl, externalIssues, failedTestResultCategory, totalTestObject, totalDefects, urlId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecutionTestResultResource {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    testCase: ").append(toIndentedString(testCase)).append("\n");
    sb.append("    execution: ").append(toIndentedString(execution)).append("\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    sameStatusPeriod: ").append(toIndentedString(sameStatusPeriod)).append("\n");
    sb.append("    errorDetailsId: ").append(toIndentedString(errorDetailsId)).append("\n");
    sb.append("    stdoutId: ").append(toIndentedString(stdoutId)).append("\n");
    sb.append("    descriptionId: ").append(toIndentedString(descriptionId)).append("\n");
    sb.append("    logId: ").append(toIndentedString(logId)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    sameFailureResults: ").append(toIndentedString(sameFailureResults)).append("\n");
    sb.append("    testSuite: ").append(toIndentedString(testSuite)).append("\n");
    sb.append("    executionTestSuite: ").append(toIndentedString(executionTestSuite)).append("\n");
    sb.append("    incidents: ").append(toIndentedString(incidents)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    hasComment: ").append(toIndentedString(hasComment)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    errorDetail: ").append(toIndentedString(errorDetail)).append("\n");
    sb.append("    webUrl: ").append(toIndentedString(webUrl)).append("\n");
    sb.append("    externalIssues: ").append(toIndentedString(externalIssues)).append("\n");
    sb.append("    failedTestResultCategory: ").append(toIndentedString(failedTestResultCategory)).append("\n");
    sb.append("    totalTestObject: ").append(toIndentedString(totalTestObject)).append("\n");
    sb.append("    totalDefects: ").append(toIndentedString(totalDefects)).append("\n");
    sb.append("    urlId: ").append(toIndentedString(urlId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
