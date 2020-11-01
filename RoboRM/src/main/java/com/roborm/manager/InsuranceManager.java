package com.roborm.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import com.roborm.exception.ResourceNotFoundException;
import com.roborm.model.Insurance;
import com.roborm.repository.InsuranceRepository;

public class InsuranceManager {
	
	private InsuranceRepository insRepo;
	
	public InsuranceManager (InsuranceRepository insRepo)
	{
		this.insRepo = insRepo;
	}
	
	public List<Insurance> findAll()
	{
		return insRepo.findAll();
	}
	
	public List<Insurance> findByUserId(Long userId) 
	{
		return insRepo.findByUserId(userId);
	}
	
	public Insurance UpdateById(Insurance insurance) throws ResourceNotFoundException
	{
		Insurance ins = insRepo.findById(insurance.getInsuranceId()).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + insurance.getInsuranceId()));
		
		ins.setInsuranceType(insurance.getInsuranceType());
		ins.setFinInstId(insurance.getFinInstId());
		ins.setPremiumAmt(insurance.getPremiumAmt());
		ins.setSumAssured(insurance.getSumAssured());
		ins.setHospitalBenefitAmt(insurance.getHospitalBenefitAmt());
		ins.setCoverage(insurance.getCoverage());
		
		final Insurance updateIns = insRepo.save(ins);
		return updateIns;
				
	}
	
	public Insurance ingestCSV()
	{
		Insurance ins = new Insurance();
		String[] values = CSVLink();
		
		ins.setUserId(Long.valueOf("1"));
		ins.setInsuranceType(values[2]);
		ins.setFinInstId(Long.valueOf("1"));
		ins.setPremiumAmt(Double.valueOf(values[5]));
		ins.setSumAssured(Double.valueOf(values[7]));
		ins.setHospitalBenefitAmt(Double.valueOf(values[8]));
		ins.setCoverage(values[3]);
		
		
		return insRepo.save(ins);
		
	}
	private static String[] CSVLink()
	{
		StringBuffer stringBuffer = new StringBuffer();
		DecimalFormat decimalFormat = new DecimalFormat("###.###"); 
		String insArray[] = new String[10];
		int i = 0;
		byte[] data = null;
		
		try { 
            URL url = new URL("https://robormbucket.s3-ap-southeast-1.amazonaws.com/output.csv"); 
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
 
            System.out.println("Connected :)"); 
 
            InputStream inputStream = connection.getInputStream(); 
            String cvsSplitBy = ",";
 
            long read_start = System.nanoTime(); 
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); 
            
            String line="";
 
            while ((line = reader.readLine()) != null) {

                // use comma as separator
                String[] details = line.split(cvsSplitBy);

                System.out.println("Detail [code1= " + details[0] + " ");
                insArray[i]=details[0];
                i++;

            }
             
            reader.close(); 
 
            long read_end = System.nanoTime(); 
 
            System.out.println("Finished reading response in " + decimalFormat.format((read_end - read_start)/Math.pow(10,6)) + " milliseconds"); 
 
 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
 
        finally { 
            data = stringBuffer.toString().getBytes(); 
        } 
		return insArray;
	}
	
}
