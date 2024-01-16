package com.example.Kel02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kel02.model.Ruangan;
import com.example.Kel02.model.Surat;
import com.example.Kel02.repository.SuratRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SuratService {

    private final SuratRepository suratRepository;

    @Autowired
    public SuratService(SuratRepository suratRepository) {
        this.suratRepository = suratRepository;
    }

    public List<Surat> getAllSurat() {
        return suratRepository.findAll();
    }

    public Optional<Surat> getSuratById(Long id) {
        return suratRepository.findById(id);
    }

    public Surat createSurat(Surat surat) {
        return suratRepository.save(surat);
    }

    public Surat updateSurat(Long id, Surat updatedSurat) {
        Optional<Surat> existingSurat = suratRepository.findById(id);
        if (existingSurat.isPresent()) {
            Surat surat = existingSurat.get();
            surat.setUser(updatedSurat.getUser());
            surat.setKeperluan(updatedSurat.getKeperluan());
            surat.setDeskripsi(updatedSurat.getDeskripsi());
            surat.setStatus(updatedSurat.getStatus());
            return suratRepository.save(surat);
        } else {
            // Handle the case when the Surat with the given id is not found
            return null;
        }
    }
	public Surat getSurat(long id) {
		return suratRepository.findById(id).get();
	}

    public void deleteSurat(Long id) {
        suratRepository.deleteById(id);
    }
    
    public List<Surat> getSuratByUser(Long userId) {
        return suratRepository.findByUserId(userId);
    }

	public Surat findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Surat existingSurat) {
		// TODO Auto-generated method stub
		
	}
    
    
}
