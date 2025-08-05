package com.codequestionmark.rendering;

import com.github.javaparser.ast.Node;

public interface luarenderer<T extends Node> {
    String render(T element);
}
