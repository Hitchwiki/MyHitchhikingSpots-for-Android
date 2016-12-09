package com.myhitchhikingspots.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SPOT".
*/
public class SpotDao extends AbstractDao<Spot, Long> {

    public static final String TABLENAME = "SPOT";

    /**
     * Properties of entity Spot.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "Name", false, "NAME");
        public final static Property Street = new Property(2, String.class, "Street", false, "STREET");
        public final static Property Zip = new Property(3, String.class, "Zip", false, "ZIP");
        public final static Property City = new Property(4, String.class, "City", false, "CITY");
        public final static Property State = new Property(5, String.class, "State", false, "STATE");
        public final static Property Country = new Property(6, String.class, "Country", false, "COUNTRY");
        public final static Property Longitude = new Property(7, Double.class, "Longitude", false, "LONGITUDE");
        public final static Property Latitude = new Property(8, Double.class, "Latitude", false, "LATITUDE");
        public final static Property GpsResolved = new Property(9, Boolean.class, "GpsResolved", false, "GPS_RESOLVED");
        public final static Property IsReverseGeocoded = new Property(10, Boolean.class, "IsReverseGeocoded", false, "IS_REVERSE_GEOCODED");
        public final static Property Note = new Property(11, String.class, "Note", false, "NOTE");
        public final static Property Description = new Property(12, String.class, "Description", false, "DESCRIPTION");
        public final static Property StartDateTime = new Property(13, java.util.Date.class, "StartDateTime", false, "START_DATE_TIME");
        public final static Property WaitingTime = new Property(14, Integer.class, "WaitingTime", false, "WAITING_TIME");
        public final static Property Hitchability = new Property(15, Integer.class, "Hitchability", false, "HITCHABILITY");
        public final static Property AttemptResult = new Property(16, Integer.class, "AttemptResult", false, "ATTEMPT_RESULT");
        public final static Property IsWaitingForARide = new Property(17, Boolean.class, "IsWaitingForARide", false, "IS_WAITING_FOR_ARIDE");
        public final static Property IsDestination = new Property(18, Boolean.class, "IsDestination", false, "IS_DESTINATION");
        public final static Property CountryCode = new Property(19, String.class, "CountryCode", false, "COUNTRY_CODE");
        public final static Property HasAccuracy = new Property(20, Boolean.class, "HasAccuracy", false, "HAS_ACCURACY");
        public final static Property Accuracy = new Property(21, Float.class, "Accuracy", false, "ACCURACY");
    }


    public SpotDao(DaoConfig config) {
        super(config);
    }
    
    public SpotDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SPOT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT," + // 1: Name
                "\"STREET\" TEXT," + // 2: Street
                "\"ZIP\" TEXT," + // 3: Zip
                "\"CITY\" TEXT," + // 4: City
                "\"STATE\" TEXT," + // 5: State
                "\"COUNTRY\" TEXT," + // 6: Country
                "\"LONGITUDE\" REAL," + // 7: Longitude
                "\"LATITUDE\" REAL," + // 8: Latitude
                "\"GPS_RESOLVED\" INTEGER," + // 9: GpsResolved
                "\"IS_REVERSE_GEOCODED\" INTEGER," + // 10: IsReverseGeocoded
                "\"NOTE\" TEXT," + // 11: Note
                "\"DESCRIPTION\" TEXT," + // 12: Description
                "\"START_DATE_TIME\" INTEGER," + // 13: StartDateTime
                "\"WAITING_TIME\" INTEGER," + // 14: WaitingTime
                "\"HITCHABILITY\" INTEGER," + // 15: Hitchability
                "\"ATTEMPT_RESULT\" INTEGER," + // 16: AttemptResult
                "\"IS_WAITING_FOR_ARIDE\" INTEGER," + // 17: IsWaitingForARide
                "\"IS_DESTINATION\" INTEGER," + // 18: IsDestination
                "\"COUNTRY_CODE\" TEXT," + // 19: CountryCode
                "\"HAS_ACCURACY\" INTEGER," + // 20: HasAccuracy
                "\"ACCURACY\" REAL);"); // 21: Accuracy
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SPOT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Spot entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String Name = entity.getName();
        if (Name != null) {
            stmt.bindString(2, Name);
        }
 
        String Street = entity.getStreet();
        if (Street != null) {
            stmt.bindString(3, Street);
        }
 
        String Zip = entity.getZip();
        if (Zip != null) {
            stmt.bindString(4, Zip);
        }
 
        String City = entity.getCity();
        if (City != null) {
            stmt.bindString(5, City);
        }
 
        String State = entity.getState();
        if (State != null) {
            stmt.bindString(6, State);
        }
 
        String Country = entity.getCountry();
        if (Country != null) {
            stmt.bindString(7, Country);
        }
 
        Double Longitude = entity.getLongitude();
        if (Longitude != null) {
            stmt.bindDouble(8, Longitude);
        }
 
        Double Latitude = entity.getLatitude();
        if (Latitude != null) {
            stmt.bindDouble(9, Latitude);
        }
 
        Boolean GpsResolved = entity.getGpsResolved();
        if (GpsResolved != null) {
            stmt.bindLong(10, GpsResolved ? 1L: 0L);
        }
 
        Boolean IsReverseGeocoded = entity.getIsReverseGeocoded();
        if (IsReverseGeocoded != null) {
            stmt.bindLong(11, IsReverseGeocoded ? 1L: 0L);
        }
 
        String Note = entity.getNote();
        if (Note != null) {
            stmt.bindString(12, Note);
        }
 
        String Description = entity.getDescription();
        if (Description != null) {
            stmt.bindString(13, Description);
        }
 
        java.util.Date StartDateTime = entity.getStartDateTime();
        if (StartDateTime != null) {
            stmt.bindLong(14, StartDateTime.getTime());
        }
 
        Integer WaitingTime = entity.getWaitingTime();
        if (WaitingTime != null) {
            stmt.bindLong(15, WaitingTime);
        }
 
        Integer Hitchability = entity.getHitchability();
        if (Hitchability != null) {
            stmt.bindLong(16, Hitchability);
        }
 
        Integer AttemptResult = entity.getAttemptResult();
        if (AttemptResult != null) {
            stmt.bindLong(17, AttemptResult);
        }
 
        Boolean IsWaitingForARide = entity.getIsWaitingForARide();
        if (IsWaitingForARide != null) {
            stmt.bindLong(18, IsWaitingForARide ? 1L: 0L);
        }
 
        Boolean IsDestination = entity.getIsDestination();
        if (IsDestination != null) {
            stmt.bindLong(19, IsDestination ? 1L: 0L);
        }
 
        String CountryCode = entity.getCountryCode();
        if (CountryCode != null) {
            stmt.bindString(20, CountryCode);
        }
 
        Boolean HasAccuracy = entity.getHasAccuracy();
        if (HasAccuracy != null) {
            stmt.bindLong(21, HasAccuracy ? 1L: 0L);
        }
 
        Float Accuracy = entity.getAccuracy();
        if (Accuracy != null) {
            stmt.bindDouble(22, Accuracy);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Spot entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String Name = entity.getName();
        if (Name != null) {
            stmt.bindString(2, Name);
        }
 
        String Street = entity.getStreet();
        if (Street != null) {
            stmt.bindString(3, Street);
        }
 
        String Zip = entity.getZip();
        if (Zip != null) {
            stmt.bindString(4, Zip);
        }
 
        String City = entity.getCity();
        if (City != null) {
            stmt.bindString(5, City);
        }
 
        String State = entity.getState();
        if (State != null) {
            stmt.bindString(6, State);
        }
 
        String Country = entity.getCountry();
        if (Country != null) {
            stmt.bindString(7, Country);
        }
 
        Double Longitude = entity.getLongitude();
        if (Longitude != null) {
            stmt.bindDouble(8, Longitude);
        }
 
        Double Latitude = entity.getLatitude();
        if (Latitude != null) {
            stmt.bindDouble(9, Latitude);
        }
 
        Boolean GpsResolved = entity.getGpsResolved();
        if (GpsResolved != null) {
            stmt.bindLong(10, GpsResolved ? 1L: 0L);
        }
 
        Boolean IsReverseGeocoded = entity.getIsReverseGeocoded();
        if (IsReverseGeocoded != null) {
            stmt.bindLong(11, IsReverseGeocoded ? 1L: 0L);
        }
 
        String Note = entity.getNote();
        if (Note != null) {
            stmt.bindString(12, Note);
        }
 
        String Description = entity.getDescription();
        if (Description != null) {
            stmt.bindString(13, Description);
        }
 
        java.util.Date StartDateTime = entity.getStartDateTime();
        if (StartDateTime != null) {
            stmt.bindLong(14, StartDateTime.getTime());
        }
 
        Integer WaitingTime = entity.getWaitingTime();
        if (WaitingTime != null) {
            stmt.bindLong(15, WaitingTime);
        }
 
        Integer Hitchability = entity.getHitchability();
        if (Hitchability != null) {
            stmt.bindLong(16, Hitchability);
        }
 
        Integer AttemptResult = entity.getAttemptResult();
        if (AttemptResult != null) {
            stmt.bindLong(17, AttemptResult);
        }
 
        Boolean IsWaitingForARide = entity.getIsWaitingForARide();
        if (IsWaitingForARide != null) {
            stmt.bindLong(18, IsWaitingForARide ? 1L: 0L);
        }
 
        Boolean IsDestination = entity.getIsDestination();
        if (IsDestination != null) {
            stmt.bindLong(19, IsDestination ? 1L: 0L);
        }
 
        String CountryCode = entity.getCountryCode();
        if (CountryCode != null) {
            stmt.bindString(20, CountryCode);
        }
 
        Boolean HasAccuracy = entity.getHasAccuracy();
        if (HasAccuracy != null) {
            stmt.bindLong(21, HasAccuracy ? 1L: 0L);
        }
 
        Float Accuracy = entity.getAccuracy();
        if (Accuracy != null) {
            stmt.bindDouble(22, Accuracy);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Spot readEntity(Cursor cursor, int offset) {
        Spot entity = new Spot( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // Name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // Street
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // Zip
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // City
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // State
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // Country
            cursor.isNull(offset + 7) ? null : cursor.getDouble(offset + 7), // Longitude
            cursor.isNull(offset + 8) ? null : cursor.getDouble(offset + 8), // Latitude
            cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0, // GpsResolved
            cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10) != 0, // IsReverseGeocoded
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // Note
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // Description
            cursor.isNull(offset + 13) ? null : new java.util.Date(cursor.getLong(offset + 13)), // StartDateTime
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // WaitingTime
            cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15), // Hitchability
            cursor.isNull(offset + 16) ? null : cursor.getInt(offset + 16), // AttemptResult
            cursor.isNull(offset + 17) ? null : cursor.getShort(offset + 17) != 0, // IsWaitingForARide
            cursor.isNull(offset + 18) ? null : cursor.getShort(offset + 18) != 0, // IsDestination
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // CountryCode
            cursor.isNull(offset + 20) ? null : cursor.getShort(offset + 20) != 0, // HasAccuracy
            cursor.isNull(offset + 21) ? null : cursor.getFloat(offset + 21) // Accuracy
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Spot entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setStreet(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setZip(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCity(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setState(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setCountry(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLongitude(cursor.isNull(offset + 7) ? null : cursor.getDouble(offset + 7));
        entity.setLatitude(cursor.isNull(offset + 8) ? null : cursor.getDouble(offset + 8));
        entity.setGpsResolved(cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0);
        entity.setIsReverseGeocoded(cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10) != 0);
        entity.setNote(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setDescription(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setStartDateTime(cursor.isNull(offset + 13) ? null : new java.util.Date(cursor.getLong(offset + 13)));
        entity.setWaitingTime(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setHitchability(cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15));
        entity.setAttemptResult(cursor.isNull(offset + 16) ? null : cursor.getInt(offset + 16));
        entity.setIsWaitingForARide(cursor.isNull(offset + 17) ? null : cursor.getShort(offset + 17) != 0);
        entity.setIsDestination(cursor.isNull(offset + 18) ? null : cursor.getShort(offset + 18) != 0);
        entity.setCountryCode(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setHasAccuracy(cursor.isNull(offset + 20) ? null : cursor.getShort(offset + 20) != 0);
        entity.setAccuracy(cursor.isNull(offset + 21) ? null : cursor.getFloat(offset + 21));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Spot entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Spot entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Spot entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}