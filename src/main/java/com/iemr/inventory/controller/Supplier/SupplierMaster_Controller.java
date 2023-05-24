package com.iemr.inventory.controller.Supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.iemr.inventory.data.employeemaster.M_UserServiceRoleMapping2;
import com.iemr.inventory.data.supplier.M_Supplier;
import com.iemr.inventory.data.supplier.M_Supplieraddress;
import com.iemr.inventory.service.supplier.SupplierInter;
import com.iemr.inventory.utils.mapper.InputMapper;
import com.iemr.inventory.utils.response.OutputResponse;

@RestController
public class SupplierMaster_Controller {
	
	@Autowired
	private SupplierInter supplierInter;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@CrossOrigin()
	@RequestMapping(value =  "/createSupplier" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String createSupplier(@RequestBody String createSupplier) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Supplier[] Supplier = InputMapper.gson().fromJson(createSupplier,
					M_Supplier[].class);
		     List<M_Supplier> SupplierData = Arrays.asList(Supplier);
		     
		     M_Supplieraddress[] Supplieraddress = InputMapper.gson().fromJson(createSupplier,M_Supplieraddress[].class);
		     List<M_Supplieraddress> SupplierAddressData = Arrays.asList(Supplieraddress);
		     
			
			ArrayList<M_Supplier> createdData=supplierInter.createSupplier(SupplierData);
			
			
			M_Supplieraddress resDataMap1 = null;
			List<M_Supplieraddress> resList1 = new ArrayList<M_Supplieraddress>();
			int x=0;
			for(M_Supplier ms:createdData){
				resDataMap1=new M_Supplieraddress();
				resDataMap1.setSupplierID(createdData.get(x).getSupplierID());
				resDataMap1.setAddressLine1(SupplierAddressData.get(x).getAddressLine1());
				resDataMap1.setAddressLine2(SupplierAddressData.get(x).getAddressLine2());
				resDataMap1.setDistrict(SupplierAddressData.get(x).getDistrict());
				resDataMap1.setState(SupplierAddressData.get(x).getState());
				resDataMap1.setCountry(SupplierAddressData.get(x).getCountry());
				resDataMap1.setPinCode(SupplierAddressData.get(x).getPinCode());
				resDataMap1.setProviderServiceMapID(SupplierAddressData.get(x).getProviderServiceMapID());
				resDataMap1.setCreatedBy(SupplierAddressData.get(x).getCreatedBy());
				resList1.add(resDataMap1);
				
			}
			x++;
			ArrayList<M_Supplieraddress> storedData=supplierInter.createAddress(resList1);
			//editData.setDeleted(Manufacturer.getDeleted());
			
			
			//M_Manufacturer saveData=manufacturerInter.saveEditedData(editData);
			
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(createdData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}

	
	
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/getSupplier" ,headers = "Authorization", method = { RequestMethod.POST }, produces = {"application/json" })
	public String getSupplier(@RequestBody String getSupplier) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Supplier Supplier = InputMapper.gson().fromJson(getSupplier,
					M_Supplier.class);
		     //List<M_Supplier> SupplierData = Arrays.asList(Supplier);
			
			ArrayList<M_Supplier> getData=supplierInter.getSupplier(Supplier.getProviderServiceMapID());
			
			//editData.setDeleted(Manufacturer.getDeleted());
			
			
			//M_Manufacturer saveData=manufacturerInter.saveEditedData(editData);
			
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(getData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	
	           
	
	@CrossOrigin()
	@RequestMapping(value =  "/editSupplier" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String editSupplier(@RequestBody String editSupplier) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Supplier Supplier = InputMapper.gson().fromJson(editSupplier,
					M_Supplier.class);
		     //List<M_Supplier> SupplierData = Arrays.asList(Supplier);
			
			M_Supplier editData=supplierInter.editSupplier(Supplier.getSupplierID());
			//M_Supplieraddress getDataBySupplierID=supplierInter.getaddData(Supp);
			editData.setSupplierName(Supplier.getSupplierName());
			editData.setSupplierDesc(Supplier.getSupplierDesc());
			editData.setSupplierCode(Supplier.getSupplierCode());
			editData.setStatus(Supplier.getStatus());
			editData.setContactPerson(Supplier.getContactPerson());
			editData.setDrugLicenseNo(Supplier.getDrugLicenseNo());
			editData.setcST_GST_No(Supplier.getcST_GST_No());
			editData.settIN_No(Supplier.gettIN_No());
			editData.setEmail(Supplier.getEmail());
			editData.setPhoneNo1(Supplier.getPhoneNo1());
			editData.setPhoneNo2(Supplier.getPhoneNo2());
			editData.setModifiedBy(Supplier.getModifiedBy());
			
			M_Supplier editedData=supplierInter.saveEditedData(editData);
			
			
			//M_Manufacturer saveData=manufacturerInter.saveEditedData(editData);
			
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(editedData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	
	
	
	
	
	
	@CrossOrigin()
	@RequestMapping(value =  "/deleteSupplier" ,headers = "Authorization", method = { RequestMethod.POST }, produces = { "application/json" })
	public String deleteSupplier(@RequestBody String deleteSupplier) {
		//JSONObject requestOBJ = new JSONObject(providerBlocking);
		
		OutputResponse response = new OutputResponse();

		try {

			M_Supplier Supplier = InputMapper.gson().fromJson(deleteSupplier,
					M_Supplier.class);
		     //List<M_Supplier> SupplierData = Arrays.asList(Supplier);
			
			M_Supplier editData=supplierInter.editSupplier(Supplier.getSupplierID());
			
			editData.setDeleted(Supplier.getDeleted());
			
			M_Supplier deletedData=supplierInter.saveEditedData(editData);
			
			
			//M_Manufacturer saveData=manufacturerInter.saveEditedData(editData);
			
			
			//ArrayList<V_Showproviderservicemapping> getProviderStatus1=blockingInter.getProviderStatus1(Pharmacologicalcategory.getServiceProviderID());
			
			response.setResponse(deletedData.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setError(e);

		}
		/**
		 * sending the response...
		 */
		return response.toString();

	}
	
	
	

}