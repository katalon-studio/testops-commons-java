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

import java.util.Objects;

/**
 * TimeZoneResourceOffsetRulesTransitionRules
 */


public class TimeZoneResourceOffsetRulesTransitionRules {
  /**
   * Gets or Sets month
   */
  public enum MonthEnum {
    JANUARY("JANUARY"),
    FEBRUARY("FEBRUARY"),
    MARCH("MARCH"),
    APRIL("APRIL"),
    MAY("MAY"),
    JUNE("JUNE"),
    JULY("JULY"),
    AUGUST("AUGUST"),
    SEPTEMBER("SEPTEMBER"),
    OCTOBER("OCTOBER"),
    NOVEMBER("NOVEMBER"),
    DECEMBER("DECEMBER");

    private String value;

    MonthEnum(String value) {
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
    public static MonthEnum fromValue(String text) {
      for (MonthEnum b : MonthEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("month")
  private MonthEnum month = null;

  /**
   * Gets or Sets timeDefinition
   */
  public enum TimeDefinitionEnum {
    UTC("UTC"),
    WALL("WALL"),
    STANDARD("STANDARD");

    private String value;

    TimeDefinitionEnum(String value) {
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
    public static TimeDefinitionEnum fromValue(String text) {
      for (TimeDefinitionEnum b : TimeDefinitionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("timeDefinition")
  private TimeDefinitionEnum timeDefinition = null;

  /**
   * Gets or Sets dayOfWeek
   */
  public enum DayOfWeekEnum {
    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY"),
    SATURDAY("SATURDAY"),
    SUNDAY("SUNDAY");

    private String value;

    DayOfWeekEnum(String value) {
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
    public static DayOfWeekEnum fromValue(String text) {
      for (DayOfWeekEnum b : DayOfWeekEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("dayOfWeek")
  private DayOfWeekEnum dayOfWeek = null;

  @JsonProperty("localTime")
  private LocalTime localTime = null;

  @JsonProperty("dayOfMonthIndicator")
  private Integer dayOfMonthIndicator = null;

  @JsonProperty("midnightEndOfDay")
  private Boolean midnightEndOfDay = null;

  public TimeZoneResourceOffsetRulesTransitionRules month(MonthEnum month) {
    this.month = month;
    return this;
  }

   /**
   * Get month
   * @return month
  **/
  @Schema(description = "")
  public MonthEnum getMonth() {
    return month;
  }

  public void setMonth(MonthEnum month) {
    this.month = month;
  }

  public TimeZoneResourceOffsetRulesTransitionRules timeDefinition(TimeDefinitionEnum timeDefinition) {
    this.timeDefinition = timeDefinition;
    return this;
  }

   /**
   * Get timeDefinition
   * @return timeDefinition
  **/
  @Schema(description = "")
  public TimeDefinitionEnum getTimeDefinition() {
    return timeDefinition;
  }

  public void setTimeDefinition(TimeDefinitionEnum timeDefinition) {
    this.timeDefinition = timeDefinition;
  }

  public TimeZoneResourceOffsetRulesTransitionRules dayOfWeek(DayOfWeekEnum dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
    return this;
  }

   /**
   * Get dayOfWeek
   * @return dayOfWeek
  **/
  @Schema(description = "")
  public DayOfWeekEnum getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(DayOfWeekEnum dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public TimeZoneResourceOffsetRulesTransitionRules localTime(LocalTime localTime) {
    this.localTime = localTime;
    return this;
  }

   /**
   * Get localTime
   * @return localTime
  **/
  @Schema(description = "")
  public LocalTime getLocalTime() {
    return localTime;
  }

  public void setLocalTime(LocalTime localTime) {
    this.localTime = localTime;
  }

  public TimeZoneResourceOffsetRulesTransitionRules dayOfMonthIndicator(Integer dayOfMonthIndicator) {
    this.dayOfMonthIndicator = dayOfMonthIndicator;
    return this;
  }

   /**
   * Get dayOfMonthIndicator
   * @return dayOfMonthIndicator
  **/
  @Schema(description = "")
  public Integer getDayOfMonthIndicator() {
    return dayOfMonthIndicator;
  }

  public void setDayOfMonthIndicator(Integer dayOfMonthIndicator) {
    this.dayOfMonthIndicator = dayOfMonthIndicator;
  }

  public TimeZoneResourceOffsetRulesTransitionRules midnightEndOfDay(Boolean midnightEndOfDay) {
    this.midnightEndOfDay = midnightEndOfDay;
    return this;
  }

   /**
   * Get midnightEndOfDay
   * @return midnightEndOfDay
  **/
  @Schema(description = "")
  public Boolean isMidnightEndOfDay() {
    return midnightEndOfDay;
  }

  public void setMidnightEndOfDay(Boolean midnightEndOfDay) {
    this.midnightEndOfDay = midnightEndOfDay;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeZoneResourceOffsetRulesTransitionRules timeZoneResourceOffsetRulesTransitionRules = (TimeZoneResourceOffsetRulesTransitionRules) o;
    return Objects.equals(this.month, timeZoneResourceOffsetRulesTransitionRules.month) &&
        Objects.equals(this.timeDefinition, timeZoneResourceOffsetRulesTransitionRules.timeDefinition) &&
        Objects.equals(this.dayOfWeek, timeZoneResourceOffsetRulesTransitionRules.dayOfWeek) &&
        Objects.equals(this.localTime, timeZoneResourceOffsetRulesTransitionRules.localTime) &&
        Objects.equals(this.dayOfMonthIndicator, timeZoneResourceOffsetRulesTransitionRules.dayOfMonthIndicator) &&
        Objects.equals(this.midnightEndOfDay, timeZoneResourceOffsetRulesTransitionRules.midnightEndOfDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(month, timeDefinition, dayOfWeek, localTime, dayOfMonthIndicator, midnightEndOfDay);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeZoneResourceOffsetRulesTransitionRules {\n");

    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    timeDefinition: ").append(toIndentedString(timeDefinition)).append("\n");
    sb.append("    dayOfWeek: ").append(toIndentedString(dayOfWeek)).append("\n");
    sb.append("    localTime: ").append(toIndentedString(localTime)).append("\n");
    sb.append("    dayOfMonthIndicator: ").append(toIndentedString(dayOfMonthIndicator)).append("\n");
    sb.append("    midnightEndOfDay: ").append(toIndentedString(midnightEndOfDay)).append("\n");
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
