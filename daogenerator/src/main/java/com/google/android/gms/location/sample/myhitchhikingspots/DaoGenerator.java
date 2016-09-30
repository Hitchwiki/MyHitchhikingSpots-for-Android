package com.myhitchhikingspots;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Created by leoboaventura on 03/03/2016.
 */
public class DaoGenerator {
    private static final String PROJECT_DIR = System.getProperty("user.dir").replace("\\", "/");
    public static void main(String args[]) throws Exception {

        Schema schema = new Schema(2, "com.myhitchhikingspots.model");
        /*Entity person = schema.addEntity("Person");
        person.addIdProperty();
        person.addStringProperty("name");
        person.addStringProperty("comment");

        Entity lease = schema.addEntity("Lease");
        lease.addIdProperty();
        lease.addStringProperty("item");
        lease.addStringProperty("comment");
        lease.addLongProperty("leasedate");
        lease.addLongProperty("returndate");

        Property personId = lease.addLongProperty("personId").getProperty();
        lease.addToOne(person, personId);

        ToMany personToLease = person.addToMany(lease, personId);
        personToLease.setName("leases");*/

        Entity spot = schema.addEntity("Spot");
        spot.addIdProperty();
        spot.addStringProperty("Name");
        spot.addStringProperty("Street");
        spot.addStringProperty("Zip");
        spot.addStringProperty("City");
        spot.addStringProperty("State");
        spot.addStringProperty("Country");

        spot.addDoubleProperty("Longitude");
        spot.addDoubleProperty("Latitude");

        spot.addBooleanProperty("GpsResolved");
        spot.addBooleanProperty("IsReverseGeocoded");

        spot.addStringProperty("Note");
        spot.addStringProperty("Description");

        spot.addDateProperty("StartDateTime");
        spot.addIntProperty("WaitingTime");

        spot.addIntProperty("Hitchability");
        spot.addIntProperty("AttemptResult");

        spot.addBooleanProperty("IsWaitingForARide");
        spot.addBooleanProperty("IsDestination");

        spot.implementsSerializable();

        new de.greenrobot.daogenerator.DaoGenerator().generateAll(schema, PROJECT_DIR + "/app/src/main/java");
    }
}
