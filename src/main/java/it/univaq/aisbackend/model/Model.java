package it.univaq.aisbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

import java.io.Serializable;
import java.util.Arrays;

public class Model implements Serializable {
    @JsonIgnore
    public static final Long serializableId = Long.MAX_VALUE;
    private String id;
    @JsonProperty("s3Key")
    private String s3Key;
    private String name;
    @JsonProperty("xOffset")
    private Float xoffset;
    @JsonProperty("yOffset")
    private Float yoffset;
    @JsonProperty("zOffset")
    private Float zoffset;
    private byte[] base64Content = null;
    private long fileSize;
    private Interaction interaction;

    public void setBase64Content(byte[] base64Content) {
        this.base64Content = base64Content;
        if (base64Content != null) {
            this.fileSize = (long) base64Content.length;
        } else {
            this.fileSize = 0L;
        }

    }

    @Generated
    public Model() {
    }

    @Generated
    public Model(final String id, final String s3Key, final String name, final Float xoffset, final Float yoffset, final Float zoffset, final byte[] base64Content, final long fileSize, final Interaction interaction) {
        this.id = id;
        this.s3Key = s3Key;
        this.name = name;
        this.xoffset = xoffset;
        this.yoffset = yoffset;
        this.zoffset = zoffset;
        this.base64Content = base64Content;
        this.fileSize = fileSize;
        this.interaction = interaction;
    }

    @Generated
    public String getId() {
        return this.id;
    }

    @Generated
    public String getS3Key() {
        return this.s3Key;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public Float getXoffset() {
        return this.xoffset;
    }

    @Generated
    public Float getYoffset() {
        return this.yoffset;
    }

    @Generated
    public Float getZoffset() {
        return this.zoffset;
    }

    @Generated
    public byte[] getBase64Content() {
        return this.base64Content;
    }

    @Generated
    public long getFileSize() {
        return this.fileSize;
    }

    @Generated
    public Interaction getInteraction() {
        return this.interaction;
    }

    @Generated
    public void setId(final String id) {
        this.id = id;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setXoffset(final Float xoffset) {
        this.xoffset = xoffset;
    }

    @Generated
    public void setYoffset(final Float yoffset) {
        this.yoffset = yoffset;
    }

    @Generated
    public void setZoffset(final Float zoffset) {
        this.zoffset = zoffset;
    }

    @Generated
    public void setFileSize(final long fileSize) {
        this.fileSize = fileSize;
    }

    @Generated
    public void setInteraction(final Interaction interaction) {
        this.interaction = interaction;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Model)) {
            return false;
        } else {
            Model other = (Model) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getFileSize() != other.getFileSize()) {
                return false;
            } else {
                Object this$s3Key = this.getS3Key();
                Object other$s3Key = other.getS3Key();
                if (this$s3Key == null) {
                    if (other$s3Key != null) {
                        return false;
                    }
                } else if (!this$s3Key.equals(other$s3Key)) {
                    return false;
                }

                Object this$xoffset = this.getXoffset();
                Object other$xoffset = other.getXoffset();
                if (this$xoffset == null) {
                    if (other$xoffset != null) {
                        return false;
                    }
                } else if (!this$xoffset.equals(other$xoffset)) {
                    return false;
                }

                Object this$yoffset = this.getYoffset();
                Object other$yoffset = other.getYoffset();
                if (this$yoffset == null) {
                    if (other$yoffset != null) {
                        return false;
                    }
                } else if (!this$yoffset.equals(other$yoffset)) {
                    return false;
                }

                Object this$zoffset = this.getZoffset();
                Object other$zoffset = other.getZoffset();
                if (this$zoffset == null) {
                    if (other$zoffset != null) {
                        return false;
                    }
                } else if (!this$zoffset.equals(other$zoffset)) {
                    return false;
                }

                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                if (!Arrays.equals(this.getBase64Content(), other.getBase64Content())) {
                    return false;
                } else {
                    Object this$interaction = this.getInteraction();
                    Object other$interaction = other.getInteraction();
                    if (this$interaction == null) {
                        if (other$interaction != null) {
                            return false;
                        }
                    } else if (!this$interaction.equals(other$interaction)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Model;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $fileSize = this.getFileSize();
        result = result * 59 + (int) ($fileSize >>> 32 ^ $fileSize);
        Object $s3Key = this.getS3Key();
        result = result * 59 + ($s3Key == null ? 43 : $s3Key.hashCode());
        Object $xoffset = this.getXoffset();
        result = result * 59 + ($xoffset == null ? 43 : $xoffset.hashCode());
        Object $yoffset = this.getYoffset();
        result = result * 59 + ($yoffset == null ? 43 : $yoffset.hashCode());
        Object $zoffset = this.getZoffset();
        result = result * 59 + ($zoffset == null ? 43 : $zoffset.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        result = result * 59 + Arrays.hashCode(this.getBase64Content());
        Object $interaction = this.getInteraction();
        result = result * 59 + ($interaction == null ? 43 : $interaction.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getId();
        return "Model(id=" + var10000 + ", s3Key=" + this.getS3Key() + ", name=" + this.getName() + ", xoffset=" + this.getXoffset() + ", yoffset=" + this.getYoffset() + ", zoffset=" + this.getZoffset() + ", base64Content=" + Arrays.toString(this.getBase64Content()) + ", fileSize=" + this.getFileSize() + ", interaction=" + String.valueOf(this.getInteraction()) + ")";
    }
}
