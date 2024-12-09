package com.oocl.coldplay.transaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ChannelEnum {

    CHANNEL_1("1", "Bank card"),
    ;

    private final String id;
    private final String name;


    public static List<ChannelDTO> getChannels() {
        return Arrays.stream(ChannelEnum.values())
                .map(channel -> new ChannelDTO(channel.id, channel.name))
                .collect(Collectors.toList());
    }
}
