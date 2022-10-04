package com.epi.gestionPatient.gestionPatient.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.epi.gestionPatient.gestionPatient.entity.Patient;
import com.epi.gestionPatient.gestionPatient.repository.PatientRepository;

@Service
public class servicePatient implements IservicePatient{
	
	@Autowired
	PatientRepository et;
	
	@Override
	public void ajouterPatient(Patient e,MultipartFile mf) throws IOException {
		
		String photo;	
		
		if(!mf.getOriginalFilename().equals("")) {
			photo = saveImage(mf);
			e.setPhoto(photo);
		}
            et.save(e);
	}

	@Override
	public List<Patient> getAllPatients() {
		
		return et.findAll();
	}

	@Override
	public Patient getPatientById(int Id) {

		return et.findById(Id).get();
	}

	@Override
	public List<Patient> getPatientBMC(String motcle) {

		return et.rechercherParMc(motcle);
	}

	@Override
	public void supprimerPatient(int Id)throws IOException {

		Patient patient = et.getById(Id);
		//String  chemin = System.getProperty("user.home") + "/images2022/";
		String  chemin = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin,patient.getPhoto());
		Files.delete(p);
		et.delete(patient);
	}

	@Override
	public void mettreAJourPatient(Patient e) {

		et.save(e);

	}
	
	/**************image****/
	
	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		//pour avoir une image unique
		String nameFile = mf.getOriginalFilename(); // recuperation de la nom de l'image
		String tab[] = nameFile.split("\\."); //diviser le nom 
		String FileModif = tab[0] +"_"+System.currentTimeMillis()+"."+tab[1];//ajouter time 
		//user.dir : emplacement courant
		//String  chemin = System.getProperty("user.home") + "/images2022/";
		String  chemin = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin,FileModif);
		Files.write(p, mf.getBytes());
		return FileModif;
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		
		String nomImage = et.findById(id).get().getPhoto();
		//Path p = Paths.get(System.getProperty("user.home")+"/images2022/",nomImage);
		Path p = Paths.get(System.getProperty("user.dir")+"/src/main/webapp/imagesdata/",nomImage);

		return Files.readAllBytes(p);//la lecture d'une image
	}


}


