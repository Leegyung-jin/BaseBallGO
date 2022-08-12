package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLionsStadiumImage is a Querydsl query type for LionsStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLionsStadiumImage extends EntityPathBase<LionsStadiumImage> {

    private static final long serialVersionUID = -7473134L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLionsStadiumImage lionsStadiumImage = new QLionsStadiumImage("lionsStadiumImage");

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final QLionsStadium lionsStadium;

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QLionsStadiumImage(String variable) {
        this(LionsStadiumImage.class, forVariable(variable), INITS);
    }

    public QLionsStadiumImage(Path<? extends LionsStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLionsStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLionsStadiumImage(PathMetadata metadata, PathInits inits) {
        this(LionsStadiumImage.class, metadata, inits);
    }

    public QLionsStadiumImage(Class<? extends LionsStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lionsStadium = inits.isInitialized("lionsStadium") ? new QLionsStadium(forProperty("lionsStadium"), inits.get("lionsStadium")) : null;
    }

}

