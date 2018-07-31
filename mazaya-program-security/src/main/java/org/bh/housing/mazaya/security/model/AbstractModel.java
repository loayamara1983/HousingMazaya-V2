package org.bh.housing.mazaya.security.model;

import javax.persistence.MappedSuperclass;

import org.bh.housing.mazaya.util.DateConverter;

import java.sql.Timestamp;
import java.time.Instant;

@MappedSuperclass
public abstract class AbstractModel implements IGlobal {

        private Timestamp createdAt;
        private Timestamp updatedAt;

        @Override
        public void setCreatedAt() {
                this.createdAt = Timestamp.from(Instant.now());
        }

        @Override
        public Timestamp getUpdatedAt() {
                return this.updatedAt;
        }

        @Override
        public String getPrettyUpdatedAt() {
                return DateConverter.prettyTimeStamp(updatedAt);
        }

        @Override
        public void setUpdatedAt() {
                this.updatedAt = Timestamp.from(Instant.now());
        }

        @Override
        public Timestamp getCreatedAt() {
                return this.createdAt;
        }

        @Override
        public String getPrettyCreatedAt() {
                return DateConverter.prettyTimeStamp(createdAt);
        }
}
