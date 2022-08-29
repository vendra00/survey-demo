package com.sample.surveydemo.model.dto.offer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OfferDto {

    @JsonProperty("expiration_date")
    private String expirationDate;

    @JsonProperty("modified")
    private String modified;

    @JsonProperty("featured")
    private String featured;

    @JsonProperty("require_terms_and_conditions")
    private int requireTermsConditions;

    @JsonProperty("conversion_cap")
    private int conversionCap;

    @JsonProperty("monthly_conversion_cap")
    private int monthlyConversionCap;

    @JsonProperty("allow_direct_links")
    private int allowDirectLinks;

    @JsonProperty("allow_multiple_conversions")
    private int allowMultipleConversions;

    @JsonProperty("dne_list_id")
    private int dneListId;

    @JsonProperty("enforce_secure_tracking_link")
    private int enforceSecureTrackingLink;

    @JsonProperty("use_payout_groups")
    private int usePayoutGroups;

    @JsonProperty("default_payout")
    private double defaultPayout;

    @JsonProperty("percent_payout")
    private double percentPayout;

    @JsonProperty("payout_cap")
    private double payoutCap;

    @JsonProperty("monthly_payout_cap")
    private double monthlyPayoutCap;

    @JsonProperty("require_approval")
    private String requireApproval;

    @JsonProperty("allow_website_links")
    private String allowWebsiteLinks;

    @JsonProperty("show_custom_variables")
    private String showCustomVariables;

    @JsonProperty("show_mail_list")
    private String showMailList;

    @JsonProperty("email_instructions")
    private String emailInstructions;

    @JsonProperty("has_goals_enabled")
    private String hasGoalsEnabled;

    @JsonProperty("use_target_rules")
    private String useTargetRules;

    @JsonProperty("is_expired")
    private String isExpired;

    @JsonProperty("dne_third_party_list")
    private boolean dneThirdPartyList;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("preview_url")
    private String previewUrl;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("protocol")
    private String protocol;

    @JsonProperty("status")
    private String status;

    @JsonProperty("payout_type")
    private String payoutType;

    @JsonProperty("session_hours")
    private String sessionHours;

    @JsonProperty("email_instructions_from")
    private String emailInstructionsFrom;

    @JsonProperty("email_instructions_subject")
    private String emailInstructionsSubject;

    @JsonProperty("default_goal_name")
    private String defaultGoalName;

    @JsonProperty("link_platform")
    private String linkPlatform;

    @JsonProperty("dne_download_url")
    private String dneDownloadUrl;

    @JsonProperty("dne_unsubscribe_url")
    private String dneUnsubscribeUrl;

    @JsonProperty("approval_status")
    private String approvalStatus;

    @JsonProperty("terms_and_conditions")
    private String termsAndConditions;
}