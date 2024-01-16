package com.example.Kel02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kel02.model.IjinBermalam;
import com.example.Kel02.repository.IjinBermalamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IjinBermalamService {
    private final IjinBermalamRepository ijinbermalamRepository;

    @Autowired
    public IjinBermalamService(IjinBermalamRepository ijinbermalamRepository) {
        this.ijinbermalamRepository = ijinbermalamRepository;
    }

    public List<IjinBermalam> getAllIjinBermalam() {
        return ijinbermalamRepository.findAll();
    }

    public Optional<IjinBermalam> getIjinBermalamById(Long id) {
        return ijinbermalamRepository.findById(id);
    }

    public IjinBermalam createIjinBermalam(IjinBermalam ijinbermalam) {
        return ijinbermalamRepository.save(ijinbermalam);
    }

    public IjinBermalam updateIjinBermalam(Long id, IjinBermalam updatedIjinBermalam) {
        Optional<IjinBermalam> existingIjinBermalam = ijinbermalamRepository.findById(id);
        if (existingIjinBermalam.isPresent()) {
        	IjinBermalam ijinbermalam = existingIjinBermalam.get();
            ijinbermalam.setUser(updatedIjinBermalam.getUser());
            ijinbermalam.setKeperluan(updatedIjinBermalam.getKeperluan());
            ijinbermalam.setWaktu_berangkat(updatedIjinBermalam.getWaktu_berangkat());
            ijinbermalam.setWaktu_kembali(updatedIjinBermalam.getWaktu_kembali());
            ijinbermalam.setStatus(updatedIjinBermalam.getStatus());
            return ijinbermalamRepository.save(ijinbermalam);
        } else {
            // Handle the case when the IjinBermalam with the given id is not found
            return null;
        }
    }
	public IjinBermalam getIjinBermalam(long id) {
		return ijinbermalamRepository.findById(id).get();
	}

    public void deleteIjinBermalam(Long id) {
        ijinbermalamRepository.deleteById(id);
    }
    
    public List<IjinBermalam> getIjinBermalamByUser(Long userId) {
        return ijinbermalamRepository.findByUserId(userId);
    }

	public IjinBermalam findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(IjinBermalam existingIjinBermalam) {
		// TODO Auto-generated method stub
		
	}
    
}
