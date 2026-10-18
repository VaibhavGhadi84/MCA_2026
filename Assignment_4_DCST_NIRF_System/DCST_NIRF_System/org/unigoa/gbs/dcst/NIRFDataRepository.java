package org.unigoa.gbs.dcst;

import java.util.*;

public class NIRFDataRepository<T extends NIRFReportable> {
    private List<T> recordList = new ArrayList<>();
    private Set<String> uniqueKeys = new HashSet<>();
    private Queue<T> processingQueue = new LinkedList<>();
    private Map<String, T> registryMap = new HashMap<>();

    public void addRecord(String key, T record) throws InvalidNIRFRecordException {
        if (record == null) {
            throw new InvalidNIRFRecordException("Validation Failed: Attempted to insert a null NIRF record.");
        }
        recordList.add(record);
        uniqueKeys.add(key);
        processingQueue.offer(record);
        registryMap.put(key, record);
    }

    public List<T> getAllRecords() { return recordList; }
    public Queue<T> getProcessingQueue() { return processingQueue; }
    public Map<String, T> getRegistryMap() { return registryMap; }

    // Feature 8: Generic function accepting any collection type
    public static <E> void inspectGenericCollection(Collection<E> collection) {
        for (E element : collection) {
            System.out.println("  [Item]: " + element.toString());
        }
    }
}