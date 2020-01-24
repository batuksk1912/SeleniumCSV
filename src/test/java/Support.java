public class Support {

    private SingleRecord singleRecord;

    public SingleRecord createSingleRecord(int item, String ccard, String name, String lname, int code) {
        singleRecord = new SingleRecord();
        singleRecord.setItem(item);
        singleRecord.setCcard(ccard);
        singleRecord.setName(name);
        singleRecord.setLname(lname);
        singleRecord.setCode(code);
        return singleRecord;
    }
}
