package com.huoxin4415.aje.core.javax.management;

@Author("huoxin4415")
public interface QueueSamplerMXBean {
	
	@DisplayName("GETTER: QueueSample")
    public QueueSample getQueueSample();
	
	@DisplayName("OPERATION: clearQueue")
	public void clearQueue(); 
}
