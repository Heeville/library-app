package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.homework.FruitInformation;
import com.group.libraryapp.dto.homework.FruitResponse;

public interface FruitRepository {
    public FruitInformation save(FruitInformation fruitInformation);
    public void fruitId(Long id);
    public FruitResponse salesPrice(String name);
}
