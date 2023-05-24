package com.iemr.inventory.data.visit;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name = "t_benvisitdetail")
public class BenVisitDetail {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
//	@Expose
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(updatable = false, insertable = false, name = "BeneficiaryRegID")
//	private BeneficiaryData beneficiaryData;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Transient
	private String serviceProviderName;

//	@Expose
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(updatable = false, insertable = false, name = "providerServiceMapID")
//	private ProviderServiceMapping providerServiceMapping;

	@Expose
	@Column(name = "VisitDateTime")
	private Timestamp visitDateTime;

	@Expose
	@Column(name = "VisitCode")
	private String visitCode;
	
	@Expose
	@Column(name = "VisitNo")
	private Short visitNo;

	@Expose
	@Column(name = "VisitReasonID")
	private Short visitReasonID;

	@Expose
	@Column(name = "VisitReason")
	private String visitReason;

	@Expose
	@Column(name = "VisitCategoryID")
	private Integer visitCategoryID;

	@Expose
	@Column(name = "VisitCategory")
	private String visitCategory;

	@Expose
	@Column(name = "PregnancyStatus")
	private String pregnancyStatus;

	@Expose
	@Column(name = "RCHID")
	private String rCHID;

	@Expose
	@Column(name = "HealthFacilityType")
	private String healthFacilityType;

	@Expose
	@Column(name = "HealthFacilityLocation")
	private String healthFacilityLocation;

	@Expose
	@Column(name = "ReportFilePath")
	private String reportFilePath;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false)
	private Timestamp lastModDate;

	@Expose
	@Column(name = "VisitFlowStatusFlag", insertable = false)
	private String visitFlowStatusFlag;
	
	@Expose
	@Column(name = "VanSerialNo")
	private Long vanSerialNo;
	
	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;
	
	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;
	
	@Expose
	@Column(name = "SyncedBy")
	private String syncedBy;
	
	@Expose
	@Column(name = "SyncedDate")
	private Timestamp syncedDate;
	
	@Expose
	@Column(name = "ReservedForChange")
	private String reservedForChange;
	
	@Expose
	@Transient
	private String beneficiaryID;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
