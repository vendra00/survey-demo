package com.sample.surveydemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OFFER_TBL")
@Entity(name = "Offer")
public class Offer extends AbstractEntity {

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "modified")
    private Timestamp modified;

    //Should be Date type but not working
    @Column(name = "featured")
    private String featured;

    @Column(name = "allow_direct_links")
    private int allowDirectLinks;

    @Column(name = "require_terms_conditions")
    private int requireTermsConditions;

    @Column(name = "conversion_cap")
    private int conversionCap;

    @Column(name = "monthly_conversion_cap")
    private int monthlyConversionCap;

    @Column(name = "allow_multiple_conversions")
    private int allowMultipleConversions;

    @Column(name = "dne_list_id")
    private int dneListId;

    @Column(name = "enforce_secure_tracking_link")
    private int enforceSecureTrackingLink;

    @Column(name = "use_payout_groups")
    private int usePayoutGroups;

    @Column(name = "default_payout")
    private double defaultPayout;

    @Column(name = "percent_payout")
    private double percentPayout;

    @Column(name = "payout_cap")
    private double payoutCap;

    @Column(name = "monthly_payout_cap")
    private double monthlyPayoutCap;

    @Column(name = "require_approval")
    private boolean requireApproval;

    @Column(name = "allow_website_links")
    private boolean allowWebsiteLinks;

    @Column(name = "show_custom_variables")
    private boolean showCustomVariables;

    @Column(name = "show_mail_list")
    private boolean showMailList;

    @Column(name = "email_instructions")
    private boolean emailInstructions;

    @Column(name = "has_goals_enabled")
    private boolean hasGoalsEnabled;

    @Column(name = "use_target_rules")
    private boolean useTargetRules;

    @Column(name = "is_expired")
    private boolean isExpired;

    @Column(name = "dne_third_party_list")
    private boolean dneThirdPartyList;

    @NotNull
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "description", length=100000, columnDefinition = "TEXT")
    private String description;

    @Column(name = "preview_url")
    private String previewUrl;

    @Column(name = "currency")
    private String currency;

    @Column(name = "protocol")
    private String protocol;

    @Column(name = "status")
    private String status;

    @Column(name = "payout_type")
    private String payoutType;

    @Column(name = "session_hours")
    private String sessionHours;

    @Column(name = "email_instructions_from")
    private String emailInstructionsFrom;

    @Column(name = "email_instructions_subject")
    private String emailInstructionsSubject;

    @Column(name = "default_goal_name")
    private String defaultGoalName;

    @Column(name = "link_platform")
    private String linkPlatform;

    @Column(name = "dne_download_url")
    private String dneDownloadUrl;

    @Column(name = "dne_unsubscribe_url")
    private String dneUnsubscribeUrl;

    @Column(name = "approval_status")
    private String approvalStatus;

    @Column(name = "terms_and_conditions")
    private String termsAndConditions;

}
