package com.vidin.inventory.node;

public class NodeNotFoundException extends RuntimeException {
    NodeNotFoundException(Long id){
        super("Could not find  the node " + id);
    }
}
