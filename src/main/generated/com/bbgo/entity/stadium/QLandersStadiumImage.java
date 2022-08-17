package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLandersStadiumImage is a Querydsl query type for LandersStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLandersStadiumImage extends EntityPathBase<LandersStadiumImage> {

    private static final long serialVersionUID = 1859677846L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLandersStadiumImage landersStadiumImage = new QLandersStadiumImage("landersStadiumImage");

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final QLandersStadium landersStadium;

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QLandersStadiumImage(String variable) {
        this(LandersStadiumImage.class, forVariable(variable), INITS);
    }

    public QLandersStadiumImage(Path<? extends LandersStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLandersStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLandersStadiumImage(PathMetadata metadata, PathInits inits) {
        this(LandersStadiumImage.class, metadata, inits);
    }

    public QLandersStadiumImage(Class<? extends LandersStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.landersStadium = inits.isInitialized("landersStadium") ? new QLandersStadium(forProperty("landersStadium"), inits.get("landersStadium")) : null;
    }

}

