package com.fred.learning.jdk8.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author zzf
 * @date 2019/12/22 下午9:58.
 */
public interface CompressionStrategy {
    OutputStream compress(OutputStream data) throws IOException;
}
