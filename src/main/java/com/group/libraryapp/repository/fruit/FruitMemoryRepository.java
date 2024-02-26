package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.homework.FruitInformation;
import com.group.libraryapp.dto.homework.FruitResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class FruitIdGenerator {
    private static long id = 1L;
    public static synchronized long generateId() {
        return id++;
    }
}
@Primary
@Repository
public class FruitMemoryRepository implements FruitRepository{

    private List<FruitInformation> fruitInformationList=new ArrayList<>();

    public FruitMemoryRepository(List<FruitInformation> fruitInformationList) {
        this.fruitInformationList = fruitInformationList;
    }

    @Override
    public FruitInformation save(FruitInformation fruitInformation) {
        fruitInformation.setId(FruitIdGenerator.generateId());
        fruitInformationList.add(fruitInformation);
        return fruitInformation;
    }

    @Override
    public void fruitId(Long id) {
        Optional<FruitInformation> fruitInfo= fruitInformationList.stream()
                .filter(info -> info.getId().equals(id))
                .findFirst();
        if (fruitInfo.isEmpty()){
            throw new IllegalArgumentException("해당 id를 가진 과일 정보가 없슴");
        }
    }

    @Override
    public FruitResponse salesPrice(String name) {
        Optional<FruitInformation> fruitInfo= fruitInformationList.stream()
                .filter(info -> info.getName().equals(name))
                .findFirst();
        if (fruitInfo.isEmpty()){
            throw new IllegalArgumentException("해당 id를 가진 과일 정보가 없슴");
        }
        long sales=fruitInformationList.stream()
                .filter(info-> info.getName().equals(name)&& info.getSales())
                .mapToLong(FruitInformation::getPrice)
                .sum();

        long notsales=fruitInformationList.stream()
                .filter(info-> info.getName().equals(name)&& !info.getSales())
                .mapToLong(FruitInformation::getPrice)
                .sum();


        return new FruitResponse(sales,notsales);
    }
}
