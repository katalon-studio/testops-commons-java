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
 * ExecutionResource
 */


public class ExecutionResource {
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

  @JsonProperty("startTime")
  private OffsetDateTime startTime = null;

  @JsonProperty("endTime")
  private OffsetDateTime endTime = null;

  @JsonProperty("duration")
  private Long duration = null;

  @JsonProperty("elapsedDuration")
  private Long elapsedDuration = null;

  @JsonProperty("totalTests")
  private Long totalTests = null;

  @JsonProperty("totalPassedTests")
  private Long totalPassedTests = null;

  @JsonProperty("totalFailedTests")
  private Long totalFailedTests = null;

  @JsonProperty("totalErrorTests")
  private Long totalErrorTests = null;

  @JsonProperty("totalIncompleteTests")
  private Long totalIncompleteTests = null;

  @JsonProperty("totalDiffTests")
  private Long totalDiffTests = null;

  @JsonProperty("totalDiffPassedTests")
  private Long totalDiffPassedTests = null;

  @JsonProperty("totalDiffFailedTests")
  private Long totalDiffFailedTests = null;

  @JsonProperty("totalDiffErrorTests")
  private Long totalDiffErrorTests = null;

  @JsonProperty("totalDiffIncompleteTests")
  private Long totalDiffIncompleteTests = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("projectId")
  private Long projectId = null;

  @JsonProperty("project")
  private ProjectResource project = null;

  @JsonProperty("buildId")
  private Long buildId = null;

  @JsonProperty("order")
  private Long order = null;

  /**
   * Gets or Sets executionStage
   */
  public enum ExecutionStageEnum {
    RUNNING("RUNNING"),
    COMPLETED("COMPLETED"),
    TERMINATE("TERMINATE"),
    ANALYZING("ANALYZING"),
    ANALYZED("ANALYZED"),
    IMPORTING("IMPORTING"),
    ERROR("ERROR");

    private String value;

    ExecutionStageEnum(String value) {
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
    public static ExecutionStageEnum fromValue(String text) {
      for (ExecutionStageEnum b : ExecutionStageEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("executionStage")
  private ExecutionStageEnum executionStage = null;

  @JsonProperty("webUrl")
  private String webUrl = null;

  @JsonProperty("testSuiteCollections")
  private List<TestSuiteCollectionEntityResource> testSuiteCollections = null;

  @JsonProperty("executionTestSuiteResources")
  private List<ExecutionTestSuiteResource> executionTestSuiteResources = null;

  @JsonProperty("release")
  private ReleaseResource release = null;

  @JsonProperty("hasComment")
  private Boolean hasComment = null;

  @JsonProperty("user")
  private UserResource user = null;

  @JsonProperty("sessionId")
  private String sessionId = null;

  @JsonProperty("buildLabel")
  private String buildLabel = null;

  @JsonProperty("buildUrl")
  private String buildUrl = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    KATALON("KATALON"),
    BDD("BDD");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("type")
  private TypeEnum type = null;

  public ExecutionResource status(StatusEnum status) {
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

  public ExecutionResource startTime(OffsetDateTime startTime) {
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

  public ExecutionResource endTime(OffsetDateTime endTime) {
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

  public ExecutionResource duration(Long duration) {
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

  public ExecutionResource elapsedDuration(Long elapsedDuration) {
    this.elapsedDuration = elapsedDuration;
    return this;
  }

   /**
   * Get elapsedDuration
   * @return elapsedDuration
  **/
  @Schema(description = "")
  public Long getElapsedDuration() {
    return elapsedDuration;
  }

  public void setElapsedDuration(Long elapsedDuration) {
    this.elapsedDuration = elapsedDuration;
  }

  public ExecutionResource totalTests(Long totalTests) {
    this.totalTests = totalTests;
    return this;
  }

   /**
   * Get totalTests
   * @return totalTests
  **/
  @Schema(description = "")
  public Long getTotalTests() {
    return totalTests;
  }

  public void setTotalTests(Long totalTests) {
    this.totalTests = totalTests;
  }

  public ExecutionResource totalPassedTests(Long totalPassedTests) {
    this.totalPassedTests = totalPassedTests;
    return this;
  }

   /**
   * Get totalPassedTests
   * @return totalPassedTests
  **/
  @Schema(description = "")
  public Long getTotalPassedTests() {
    return totalPassedTests;
  }

  public void setTotalPassedTests(Long totalPassedTests) {
    this.totalPassedTests = totalPassedTests;
  }

  public ExecutionResource totalFailedTests(Long totalFailedTests) {
    this.totalFailedTests = totalFailedTests;
    return this;
  }

   /**
   * Get totalFailedTests
   * @return totalFailedTests
  **/
  @Schema(description = "")
  public Long getTotalFailedTests() {
    return totalFailedTests;
  }

  public void setTotalFailedTests(Long totalFailedTests) {
    this.totalFailedTests = totalFailedTests;
  }

  public ExecutionResource totalErrorTests(Long totalErrorTests) {
    this.totalErrorTests = totalErrorTests;
    return this;
  }

   /**
   * Get totalErrorTests
   * @return totalErrorTests
  **/
  @Schema(description = "")
  public Long getTotalErrorTests() {
    return totalErrorTests;
  }

  public void setTotalErrorTests(Long totalErrorTests) {
    this.totalErrorTests = totalErrorTests;
  }

  public ExecutionResource totalIncompleteTests(Long totalIncompleteTests) {
    this.totalIncompleteTests = totalIncompleteTests;
    return this;
  }

   /**
   * Get totalIncompleteTests
   * @return totalIncompleteTests
  **/
  @Schema(description = "")
  public Long getTotalIncompleteTests() {
    return totalIncompleteTests;
  }

  public void setTotalIncompleteTests(Long totalIncompleteTests) {
    this.totalIncompleteTests = totalIncompleteTests;
  }

  public ExecutionResource totalDiffTests(Long totalDiffTests) {
    this.totalDiffTests = totalDiffTests;
    return this;
  }

   /**
   * Get totalDiffTests
   * @return totalDiffTests
  **/
  @Schema(description = "")
  public Long getTotalDiffTests() {
    return totalDiffTests;
  }

  public void setTotalDiffTests(Long totalDiffTests) {
    this.totalDiffTests = totalDiffTests;
  }

  public ExecutionResource totalDiffPassedTests(Long totalDiffPassedTests) {
    this.totalDiffPassedTests = totalDiffPassedTests;
    return this;
  }

   /**
   * Get totalDiffPassedTests
   * @return totalDiffPassedTests
  **/
  @Schema(description = "")
  public Long getTotalDiffPassedTests() {
    return totalDiffPassedTests;
  }

  public void setTotalDiffPassedTests(Long totalDiffPassedTests) {
    this.totalDiffPassedTests = totalDiffPassedTests;
  }

  public ExecutionResource totalDiffFailedTests(Long totalDiffFailedTests) {
    this.totalDiffFailedTests = totalDiffFailedTests;
    return this;
  }

   /**
   * Get totalDiffFailedTests
   * @return totalDiffFailedTests
  **/
  @Schema(description = "")
  public Long getTotalDiffFailedTests() {
    return totalDiffFailedTests;
  }

  public void setTotalDiffFailedTests(Long totalDiffFailedTests) {
    this.totalDiffFailedTests = totalDiffFailedTests;
  }

  public ExecutionResource totalDiffErrorTests(Long totalDiffErrorTests) {
    this.totalDiffErrorTests = totalDiffErrorTests;
    return this;
  }

   /**
   * Get totalDiffErrorTests
   * @return totalDiffErrorTests
  **/
  @Schema(description = "")
  public Long getTotalDiffErrorTests() {
    return totalDiffErrorTests;
  }

  public void setTotalDiffErrorTests(Long totalDiffErrorTests) {
    this.totalDiffErrorTests = totalDiffErrorTests;
  }

  public ExecutionResource totalDiffIncompleteTests(Long totalDiffIncompleteTests) {
    this.totalDiffIncompleteTests = totalDiffIncompleteTests;
    return this;
  }

   /**
   * Get totalDiffIncompleteTests
   * @return totalDiffIncompleteTests
  **/
  @Schema(description = "")
  public Long getTotalDiffIncompleteTests() {
    return totalDiffIncompleteTests;
  }

  public void setTotalDiffIncompleteTests(Long totalDiffIncompleteTests) {
    this.totalDiffIncompleteTests = totalDiffIncompleteTests;
  }

  public ExecutionResource id(Long id) {
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

  public ExecutionResource projectId(Long projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * Get projectId
   * @return projectId
  **/
  @Schema(description = "")
  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public ExecutionResource project(ProjectResource project) {
    this.project = project;
    return this;
  }

   /**
   * Get project
   * @return project
  **/
  @Schema(description = "")
  public ProjectResource getProject() {
    return project;
  }

  public void setProject(ProjectResource project) {
    this.project = project;
  }

  public ExecutionResource buildId(Long buildId) {
    this.buildId = buildId;
    return this;
  }

   /**
   * Get buildId
   * @return buildId
  **/
  @Schema(description = "")
  public Long getBuildId() {
    return buildId;
  }

  public void setBuildId(Long buildId) {
    this.buildId = buildId;
  }

  public ExecutionResource order(Long order) {
    this.order = order;
    return this;
  }

   /**
   * Get order
   * @return order
  **/
  @Schema(description = "")
  public Long getOrder() {
    return order;
  }

  public void setOrder(Long order) {
    this.order = order;
  }

  public ExecutionResource executionStage(ExecutionStageEnum executionStage) {
    this.executionStage = executionStage;
    return this;
  }

   /**
   * Get executionStage
   * @return executionStage
  **/
  @Schema(description = "")
  public ExecutionStageEnum getExecutionStage() {
    return executionStage;
  }

  public void setExecutionStage(ExecutionStageEnum executionStage) {
    this.executionStage = executionStage;
  }

  public ExecutionResource webUrl(String webUrl) {
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

  public ExecutionResource testSuiteCollections(List<TestSuiteCollectionEntityResource> testSuiteCollections) {
    this.testSuiteCollections = testSuiteCollections;
    return this;
  }

  public ExecutionResource addTestSuiteCollectionsItem(TestSuiteCollectionEntityResource testSuiteCollectionsItem) {
    if (this.testSuiteCollections == null) {
      this.testSuiteCollections = new ArrayList<TestSuiteCollectionEntityResource>();
    }
    this.testSuiteCollections.add(testSuiteCollectionsItem);
    return this;
  }

   /**
   * Get testSuiteCollections
   * @return testSuiteCollections
  **/
  @Schema(description = "")
  public List<TestSuiteCollectionEntityResource> getTestSuiteCollections() {
    return testSuiteCollections;
  }

  public void setTestSuiteCollections(List<TestSuiteCollectionEntityResource> testSuiteCollections) {
    this.testSuiteCollections = testSuiteCollections;
  }

  public ExecutionResource executionTestSuiteResources(List<ExecutionTestSuiteResource> executionTestSuiteResources) {
    this.executionTestSuiteResources = executionTestSuiteResources;
    return this;
  }

  public ExecutionResource addExecutionTestSuiteResourcesItem(ExecutionTestSuiteResource executionTestSuiteResourcesItem) {
    if (this.executionTestSuiteResources == null) {
      this.executionTestSuiteResources = new ArrayList<ExecutionTestSuiteResource>();
    }
    this.executionTestSuiteResources.add(executionTestSuiteResourcesItem);
    return this;
  }

   /**
   * Get executionTestSuiteResources
   * @return executionTestSuiteResources
  **/
  @Schema(description = "")
  public List<ExecutionTestSuiteResource> getExecutionTestSuiteResources() {
    return executionTestSuiteResources;
  }

  public void setExecutionTestSuiteResources(List<ExecutionTestSuiteResource> executionTestSuiteResources) {
    this.executionTestSuiteResources = executionTestSuiteResources;
  }

  public ExecutionResource release(ReleaseResource release) {
    this.release = release;
    return this;
  }

   /**
   * Get release
   * @return release
  **/
  @Schema(description = "")
  public ReleaseResource getRelease() {
    return release;
  }

  public void setRelease(ReleaseResource release) {
    this.release = release;
  }

  public ExecutionResource hasComment(Boolean hasComment) {
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

  public ExecutionResource user(UserResource user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @Schema(description = "")
  public UserResource getUser() {
    return user;
  }

  public void setUser(UserResource user) {
    this.user = user;
  }

  public ExecutionResource sessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

   /**
   * Get sessionId
   * @return sessionId
  **/
  @Schema(description = "")
  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public ExecutionResource buildLabel(String buildLabel) {
    this.buildLabel = buildLabel;
    return this;
  }

   /**
   * Get buildLabel
   * @return buildLabel
  **/
  @Schema(description = "")
  public String getBuildLabel() {
    return buildLabel;
  }

  public void setBuildLabel(String buildLabel) {
    this.buildLabel = buildLabel;
  }

  public ExecutionResource buildUrl(String buildUrl) {
    this.buildUrl = buildUrl;
    return this;
  }

   /**
   * Get buildUrl
   * @return buildUrl
  **/
  @Schema(description = "")
  public String getBuildUrl() {
    return buildUrl;
  }

  public void setBuildUrl(String buildUrl) {
    this.buildUrl = buildUrl;
  }

  public ExecutionResource type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @Schema(description = "")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExecutionResource executionResource = (ExecutionResource) o;
    return Objects.equals(this.status, executionResource.status) &&
        Objects.equals(this.startTime, executionResource.startTime) &&
        Objects.equals(this.endTime, executionResource.endTime) &&
        Objects.equals(this.duration, executionResource.duration) &&
        Objects.equals(this.elapsedDuration, executionResource.elapsedDuration) &&
        Objects.equals(this.totalTests, executionResource.totalTests) &&
        Objects.equals(this.totalPassedTests, executionResource.totalPassedTests) &&
        Objects.equals(this.totalFailedTests, executionResource.totalFailedTests) &&
        Objects.equals(this.totalErrorTests, executionResource.totalErrorTests) &&
        Objects.equals(this.totalIncompleteTests, executionResource.totalIncompleteTests) &&
        Objects.equals(this.totalDiffTests, executionResource.totalDiffTests) &&
        Objects.equals(this.totalDiffPassedTests, executionResource.totalDiffPassedTests) &&
        Objects.equals(this.totalDiffFailedTests, executionResource.totalDiffFailedTests) &&
        Objects.equals(this.totalDiffErrorTests, executionResource.totalDiffErrorTests) &&
        Objects.equals(this.totalDiffIncompleteTests, executionResource.totalDiffIncompleteTests) &&
        Objects.equals(this.id, executionResource.id) &&
        Objects.equals(this.projectId, executionResource.projectId) &&
        Objects.equals(this.project, executionResource.project) &&
        Objects.equals(this.buildId, executionResource.buildId) &&
        Objects.equals(this.order, executionResource.order) &&
        Objects.equals(this.executionStage, executionResource.executionStage) &&
        Objects.equals(this.webUrl, executionResource.webUrl) &&
        Objects.equals(this.testSuiteCollections, executionResource.testSuiteCollections) &&
        Objects.equals(this.executionTestSuiteResources, executionResource.executionTestSuiteResources) &&
        Objects.equals(this.release, executionResource.release) &&
        Objects.equals(this.hasComment, executionResource.hasComment) &&
        Objects.equals(this.user, executionResource.user) &&
        Objects.equals(this.sessionId, executionResource.sessionId) &&
        Objects.equals(this.buildLabel, executionResource.buildLabel) &&
        Objects.equals(this.buildUrl, executionResource.buildUrl) &&
        Objects.equals(this.type, executionResource.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, startTime, endTime, duration, elapsedDuration, totalTests, totalPassedTests, totalFailedTests, totalErrorTests, totalIncompleteTests, totalDiffTests, totalDiffPassedTests, totalDiffFailedTests, totalDiffErrorTests, totalDiffIncompleteTests, id, projectId, project, buildId, order, executionStage, webUrl, testSuiteCollections, executionTestSuiteResources, release, hasComment, user, sessionId, buildLabel, buildUrl, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExecutionResource {\n");

    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    elapsedDuration: ").append(toIndentedString(elapsedDuration)).append("\n");
    sb.append("    totalTests: ").append(toIndentedString(totalTests)).append("\n");
    sb.append("    totalPassedTests: ").append(toIndentedString(totalPassedTests)).append("\n");
    sb.append("    totalFailedTests: ").append(toIndentedString(totalFailedTests)).append("\n");
    sb.append("    totalErrorTests: ").append(toIndentedString(totalErrorTests)).append("\n");
    sb.append("    totalIncompleteTests: ").append(toIndentedString(totalIncompleteTests)).append("\n");
    sb.append("    totalDiffTests: ").append(toIndentedString(totalDiffTests)).append("\n");
    sb.append("    totalDiffPassedTests: ").append(toIndentedString(totalDiffPassedTests)).append("\n");
    sb.append("    totalDiffFailedTests: ").append(toIndentedString(totalDiffFailedTests)).append("\n");
    sb.append("    totalDiffErrorTests: ").append(toIndentedString(totalDiffErrorTests)).append("\n");
    sb.append("    totalDiffIncompleteTests: ").append(toIndentedString(totalDiffIncompleteTests)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    buildId: ").append(toIndentedString(buildId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    executionStage: ").append(toIndentedString(executionStage)).append("\n");
    sb.append("    webUrl: ").append(toIndentedString(webUrl)).append("\n");
    sb.append("    testSuiteCollections: ").append(toIndentedString(testSuiteCollections)).append("\n");
    sb.append("    executionTestSuiteResources: ").append(toIndentedString(executionTestSuiteResources)).append("\n");
    sb.append("    release: ").append(toIndentedString(release)).append("\n");
    sb.append("    hasComment: ").append(toIndentedString(hasComment)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
    sb.append("    buildLabel: ").append(toIndentedString(buildLabel)).append("\n");
    sb.append("    buildUrl: ").append(toIndentedString(buildUrl)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
