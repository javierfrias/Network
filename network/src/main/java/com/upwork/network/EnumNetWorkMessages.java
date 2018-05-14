package com.upwork.network;

public enum EnumNetWorkMessages {

	NETWORK_INPUT_SIZE_ERROR {
        @Override
        public String toString() {
            return "Input network number size cannot be negative.";

        }
    },
    NETWORK_FULL_ERROR {
        @Override
        public String toString() {
            return "The Network is full of capacity.";
        }
    },
    NETWORK_CONNECT_INPUT_ERROR{
        @Override
        public String toString() {
            return "Input for connect cannot be negative.";
        }
    },
    
    NETWORK_QUERY_INPUT_ERROR{
        @Override
        public String toString() {
            return "Input for query cannot be negative.";
        }
    },
    
    NETWORK_VALUES_NOT_FOUND_ERROR{
        @Override
        public String toString() {
            return "Values were not found.";
        }
    }
    
}
