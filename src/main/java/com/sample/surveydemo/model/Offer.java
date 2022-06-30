package com.sample.surveydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sample.surveydemo.model.enums.Checker;
import com.sample.surveydemo.model.enums.Currency;
import com.sample.surveydemo.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity @Getter @Setter @JsonIgnoreProperties(ignoreUnknown = true)
public class Offer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private int requireApproval;

    @NotNull
    private int requireTermsConditions;

    @NotNull
    private String preview_url;

    @NotNull
    private String currency = Currency.UNDEFINED.name();

    @NotNull
    private double defaultPayout;

    @NotNull
    private String protocol;

    @NotNull
    private String status = Status.UNDEFINED.name();

    @NotNull
    private String expirationDate;

    @NotNull
    private String payoutType;

    private double percentPayout;

    @NotNull
    private String featured;

    @NotNull
    private int conversionCap;

    @NotNull
    private int monthlyConversionCap;

    @NotNull
    private double payoutCap;

    @NotNull
    private double monthlyPayoutCap;

    @NotNull
    private int allowMultipleConversions = Checker.UNDEFINED.ordinal();

    @NotNull
    private int allowWebsiteLinks = Checker.UNDEFINED.ordinal();

    @NotNull
    private int showCustomVariables = Checker.UNDEFINED.ordinal();

    @NotNull
    private String sessionHours;

    @NotNull
    private int showMailList = Checker.UNDEFINED.ordinal();

    @NotNull
    private int dneListId = Checker.UNDEFINED.ordinal();

    @NotNull
    private int emailInstructions = Checker.UNDEFINED.ordinal();

    private String emailInstructionsFrom;

    private String emailInstructionsSubject;

    @NotNull
    private int enforceSecureTrackingLink = Checker.UNDEFINED.ordinal();

    @NotNull
    private int hasGoalsEnabled = Checker.UNDEFINED.ordinal();

    private String defaultGoalName;

    @NotNull
    private int modified;

    @NotNull
    private int useTargetRules = Checker.UNDEFINED.ordinal();

    @NotNull
    private int usePayoutGroups = Checker.UNDEFINED.ordinal();

    private String linkPlatform;

    @NotNull
    private int isExpired = Checker.UNDEFINED.ordinal();

    private String dneDownloadUrl;

    private String dneUnsubscribeUrl;

    @NotNull
    private boolean dneThirdPartyList;

    private String approvalStatus;

}
