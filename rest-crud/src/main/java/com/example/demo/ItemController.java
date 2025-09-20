
package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
  @Autowired private ItemRepository repo;
  @GetMapping public List<Item> all(){ return repo.findAll(); }
  @PostMapping public Item add(@RequestBody Item i){ return repo.save(i); }
  @GetMapping("/{id}") public Item one(@PathVariable Long id){ return repo.findById(id).orElse(null); }
  @DeleteMapping("/{id}") public void del(@PathVariable Long id){ repo.deleteById(id); }
}
