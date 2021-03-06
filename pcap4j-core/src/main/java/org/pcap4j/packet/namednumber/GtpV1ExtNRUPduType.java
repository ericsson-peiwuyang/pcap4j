package org.pcap4j.packet.namednumber;

import java.util.HashMap;
import java.util.Map;

public final class GtpV1ExtNRUPduType
        extends NamedNumber<Byte, GtpV1ExtNRUPduType> {

    private static final long serialVersionUID = -6220918834013752192L;

    /** DL USER DATA: 0 */
    public static final GtpV1ExtNRUPduType DL_USER_DATA =
            new GtpV1ExtNRUPduType((byte) 0, "DL USER DATA");

    private static final Map<Byte, GtpV1ExtNRUPduType> registry =
            new HashMap<Byte, GtpV1ExtNRUPduType>();

    static {
        registry.put(DL_USER_DATA.value(), DL_USER_DATA);
    }

    /**
     * @param value value
     * @param name name
     */
    public GtpV1ExtNRUPduType(Byte value, String name) {
        super(value, name);
        if ((value & 0xF0) != 0) {
            throw new IllegalArgumentException(
                    value
                            + " is invalid value. PDU type of GTPv1 NRU must be between 0 and 15");
        }
    }

    /**
     * @param value value
     * @return a GtpV1ExtNRUPduType object.
     */
    public static GtpV1ExtNRUPduType getInstance(Byte value) {
        if (registry.containsKey(value)) {
            return registry.get(value);
        } else {
            return new GtpV1ExtNRUPduType(value, "unknown");
        }
    }

    /**
     * @param version version
     * @return a GtpV1ExtNRUPduType object.
     */
    public static GtpV1ExtNRUPduType register(
            GtpV1ExtNRUPduType version) {
        return registry.put(version.value(), version);
    }

    @Override
    public int compareTo(GtpV1ExtNRUPduType o) {
        return value().compareTo(o.value());
    }
}
