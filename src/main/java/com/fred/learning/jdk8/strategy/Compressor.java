package com.fred.learning.jdk8.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;

/**
 * License  :  Copyright @2019 learning Technology. All rights reserved.
 * Software :  todo
 * Author   :  zzf
 * Time     :  2019-12-22
 * Desc     :  压缩
 */
public class Compressor {

    private final CompressionStrategy strategy;

    public Compressor(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {

//        Path path = outFile.toPath();
        try(OutputStream outputStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, strategy.compress(outputStream));
        }
    }


    public static void main(String[] args) throws IOException {
        File infile = null;
        File outFile = null;
        Compressor gzip = new Compressor(new GzipCompressionStrategy());
        gzip.compress(infile.toPath(), outFile);

        Compressor zip = new Compressor(new ZipCompressionStrategy());
        zip.compress(infile.toPath(), outFile);



        //方法引用, 怎么确定 指定的 策略类？？？
        Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
        gzipCompressor.compress(infile.toPath(), outFile);
    }

    static class Demo {

    }

}
