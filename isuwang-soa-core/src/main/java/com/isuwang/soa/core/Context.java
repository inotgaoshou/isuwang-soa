package com.isuwang.soa.core;

/**
 * 配置信息
 *
 * @author craneding
 * @date 15/9/24
 */
public class Context {

    private CodecProtocol codecProtocol = CodecProtocol.CompressedBinary;

    private String calleeIp;

    private int calleePort;

    private long calleeTimeout;

    private SoaHeader header;

    private Integer seqid;

    private boolean hasHeader = false;

    private int failedTimes = 0;

    public int getFailedTimes() {
        return failedTimes;
    }

    public void setFailedTimes(int failedTimes) {
        this.failedTimes = failedTimes;
    }

    protected Context() {
    }

    public CodecProtocol getCodecProtocol() {
        return codecProtocol;
    }

    public void setCodecProtocol(CodecProtocol codecProtocol) {
        this.codecProtocol = codecProtocol;
    }

    public String getCalleeIp() {
        return calleeIp;
    }

    public void setCalleeIp(String calleeIp) {
        this.calleeIp = calleeIp;
    }

    public int getCalleePort() {
        return calleePort;
    }

    public void setCalleePort(int calleePort) {
        this.calleePort = calleePort;
    }

    public long getCalleeTimeout() {
        return calleeTimeout;
    }

    public void setCalleeTimeout(long calleeTimeout) {
        this.calleeTimeout = calleeTimeout;
    }

    public SoaHeader getHeader() {
        return header;
    }

    public void setHeader(SoaHeader header) {
        this.header = header;
    }

    public boolean isHasHeader() {
        return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    public Integer getSeqid() {
        return seqid;
    }

    public void setSeqid(Integer seqid) {
        this.seqid = seqid;
    }

    public static class Factory {
        private static ThreadLocal<Context> threadLocal = new ThreadLocal<>();

        public static Context getNewInstance() {
            return new Context();
        }

        public static Context setCurrentInstance(Context context) {
            threadLocal.set(context);

            return context;
        }

        public static Context getCurrentInstance() {
            Context context = threadLocal.get();

            if (context == null) {
                context = getNewInstance();

                threadLocal.set(context);
            }

            return context;
        }

        public static void removeCurrentInstance() {
            threadLocal.remove();
        }
    }

    public static enum CodecProtocol {
        Binary((byte) 0), CompressedBinary((byte) 1), Json((byte) 2), Xml((byte) 3);

        private byte code;

        private CodecProtocol(byte code) {
            this.code = code;
        }

        public byte getCode() {
            return code;
        }

        public static CodecProtocol toCodecProtocol(byte code) {
            CodecProtocol[] values = CodecProtocol.values();
            for (CodecProtocol protocol : values) {
                if (protocol.getCode() == code)
                    return protocol;
            }

            return null;
        }
    }
}
