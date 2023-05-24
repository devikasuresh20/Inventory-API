package com.iemr.inventory.data.indent;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.data.items.ItemMaster;
import com.iemr.inventory.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name="t_indentorder")
public class IndentOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="IndentOrderID")
	private Long indentOrderID;
	
	@Expose
	@Column(name="IndentID")
	private Long indentID;
	
	@Expose
	@Column(name="ItemID")
	private Long itemID;
	
	@Expose
	@Column(name="itemName")
	private String itemName;
	
	@Expose
	@Column(name="QOH")
	private Long qOH;
	
	@Expose
	@Column(name="RequiredQty")
	private Long requiredQty;
	
	@Expose
	@Column(name="Remarks")
	private String remarks;
	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name="VanID")
	private Long vanID;
	
	@Expose
	@Column(name="Status")
	private String status;

	
	@Expose
	@Column(name="Deleted", updatable = true, insertable = false)
	private Boolean deleted;
	
	@Expose
	@Column(name="Processed")
	private String processed;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name="CreatedDate")
	private Timestamp createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate", updatable = false, insertable = false)
	private Timestamp lastModDate;
	
	@Expose
	@Column(name="ParkingPlaceID")
	private Long parkingPlaceID;
	
	@Expose
	@Column(name="VanSerialNo", updatable = false, insertable = false)
	private Long vanSerialNo;
	
	@Expose
	@Column(name="FromFacilityID")
	private Integer fromFacilityID;
	
	@Expose
	@Column(name="SyncFacilityID")
	private Integer syncFacilityID;
	
	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(updatable = false, insertable = false, name = "IndentID",referencedColumnName="vanSerialNo")
	@JoinColumns({
		@JoinColumn(updatable = false, insertable = false, name = "IndentID",referencedColumnName="vanSerialNo"),
		@JoinColumn(updatable = false, insertable = false, name = "syncFacilityID", referencedColumnName = "syncFacilityID")
		})
	private Indent indent;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "itemID")
	private ItemMaster item;
	
	@Expose
	@Transient
	private Long indentIssueID;
	
	@Expose
	@Transient
	private Long indentIssueIDOrderID;
	
	@Expose
	@Transient
	private Long indentIssueIDVanID;
	
	@Transient
	private Integer facilityID;
	
	@Transient
	private Timestamp startDateTime;
	
	@Transient
	private Timestamp endDateTime;
	
	@Transient
	private Integer indentFromID;
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	public IndentOrder()
	{
		
	}

	public IndentOrder(Long indentOrderID, Long indentID, Long itemID, String itemName, Long qOH, Long requiredQty, String remarks,
			Integer providerServiceMapID,  String status, Boolean deleted, String processed, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate, Long vanID,Long parkingPlaceID, Long indentIssueID) {
		
		this.indentOrderID=indentOrderID;
		this.indentID=indentID;
		this.itemID=itemID;
		this.itemName=itemName;
		this.qOH=qOH;
		this.requiredQty=requiredQty;
		this.remarks=remarks;
		this.providerServiceMapID=providerServiceMapID;
		this.vanID=vanID;
		this.status=status;
		this.deleted=deleted;
		this.processed=processed;
		this.createdBy=createdBy;
		this.createdDate=createdDate;
		this.modifiedBy=modifiedBy;
		this.lastModDate=lastModDate;
		this.parkingPlaceID=parkingPlaceID;
		this.indentIssueID=indentIssueID;
	}
	
}
