package com.sample.surveydemo.model.dto.offer;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter @Setter
public class OfferDto {
    private LocalDateTime expirationDate;
    private Timestamp modified;
    private String featured;
    private int requireTermsConditions;
    private int conversionCap;
    private int monthlyConversionCap;
    private int allowDirectLinks;
    private int allowMultipleConversions;
    private int dneListId;
    private int enforceSecureTrackingLink;
    private int usePayoutGroups;
    private double defaultPayout;
    private double percentPayout;
    private double payoutCap;
    private double monthlyPayoutCap;
    private boolean requireApproval;
    private boolean allowWebsiteLinks;
    private boolean showCustomVariables;
    private boolean showMailList;
    private boolean emailInstructions;
    private boolean hasGoalsEnabled;
    private boolean useTargetRules;
    private boolean isExpired;
    private boolean dneThirdPartyList;
    private String name;
    private String description;
    private String previewUrl;
    private String currency;
    private String protocol;
    private String status;
    private String payoutType;
    private String sessionHours;
    private String emailInstructionsFrom;
    private String emailInstructionsSubject;
    private String defaultGoalName;
    private String linkPlatform;
    private String dneDownloadUrl;
    private String dneUnsubscribeUrl;
    private String approvalStatus;
    private String termsAndConditions;
}