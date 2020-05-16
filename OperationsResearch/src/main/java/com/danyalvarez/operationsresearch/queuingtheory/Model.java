package com.danyalvarez.operationsresearch.queuingtheory;

import androidx.fragment.app.Fragment;

import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MM1CFragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MM1Fragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MM1KFragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MMSCFragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MMSFragment;
import com.danyalvarez.operationsresearch.queuingtheory.models.fragments.MMSKFragment;

public enum Model {
    MM1("M/M/1") {
        @Override
        public Fragment getFragment() {
            return new MM1Fragment();
        }
    },
    MMS("M/M/S") {
        @Override
        public Fragment getFragment() {
            return new MMSFragment();
        }
    },
    MM1C("M/M/1/C") {
        @Override
        public Fragment getFragment() {
            return new MM1CFragment();
        }
    },
    MMSC("M/M/S/C") {
        @Override
        public Fragment getFragment() {
            return new MMSCFragment();
        }
    },
    MM1K("M/M/1/K") {
        @Override
        public Fragment getFragment() {
            return new MM1KFragment();
        }
    },
    MMSK("M/M/S/K") {
        @Override
        public Fragment getFragment() {
            return new MMSKFragment();
        }
    };

    private final String title;

    Model(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract Fragment getFragment();
}