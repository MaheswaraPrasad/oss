package com.vidin.inventory.node;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NodeController {

    private final NodeRepository nodeRepository;

    public NodeController(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @PostMapping("/nodes")
    public Node createNode(@RequestBody Node node){
        return this.nodeRepository.save(node);
    }

    @GetMapping("/nodes")
    public List<Node> getNodes(){
        return this.nodeRepository.findAll();
    }

    @GetMapping("/nodes/{id}")
    public Node getNode(@PathVariable Long id){
        return this.nodeRepository.findById(id).orElseThrow(() -> new NodeNotFoundException(id));
    }

}
