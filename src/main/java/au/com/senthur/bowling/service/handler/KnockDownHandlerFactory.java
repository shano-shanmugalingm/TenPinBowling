package au.com.senthur.bowling.service.handler;

import au.com.senthur.bowling.dto.KnockDownType;
import au.com.senthur.bowling.service.handler.impl.MissHandler;
import au.com.senthur.bowling.service.handler.impl.PartialHandler;
import au.com.senthur.bowling.service.handler.impl.SpareHandler;
import au.com.senthur.bowling.service.handler.impl.StrikeHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory to provide the appropriate handler
 * */
public class KnockDownHandlerFactory {

    private static Map<KnockDownType, KnockDownHandler> handlers = new HashMap<>();

    static {
        handlers.put(KnockDownType.STRIKE, new StrikeHandler());
        handlers.put(KnockDownType.SPARE, new SpareHandler());
        handlers.put(KnockDownType.MISS, new MissHandler());
        handlers.put(KnockDownType.PARTIAL, new PartialHandler());
    }

    /**
     * Returns the appropriate handler based on KnockDownType
     *
     * @param knockDownType {@link KnockDownType}
     * @return {@link KnockDownHandler}
     * */
    public KnockDownHandler getHandler(KnockDownType knockDownType) {
        return handlers.get(knockDownType);
    }

}
