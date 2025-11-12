package com.marrowbuster.particleHolograms.utils;

import com.marrowbuster.particleHolograms.shapes.Vector;

import java.io.File;

public class ObjFile extends File {
    public ObjFile(ObjFile parent, String child) {
        super(parent, child);
    }
}
