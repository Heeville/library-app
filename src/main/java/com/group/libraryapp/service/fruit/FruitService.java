package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.homework.FruitInformation;
import com.group.libraryapp.dto.homework.FruitResponse;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public FruitInformation saveInformation(FruitInformation fruitInformation){
        return fruitRepository.save(fruitInformation);
    }

    public void fruitId(Long id){
        fruitRepository.fruitId(id);
    }

    public FruitResponse SalasPrice(String name){
        return fruitRepository.salesPrice(name);
    }

}
