package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTwinsStadiumImage is a Querydsl query type for TwinsStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTwinsStadiumImage extends EntityPathBase<TwinsStadiumImage> {

    private static final long serialVersionUID = -1078817594L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTwinsStadiumImage twinsStadiumImage = new QTwinsStadiumImage("twinsStadiumImage");

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final StringPath path = createString("path");

    public final QTwinsStadium twinsStadium;

    public final StringPath uuid = createString("uuid");

    public QTwinsStadiumImage(String variable) {
        this(TwinsStadiumImage.class, forVariable(variable), INITS);
    }

    public QTwinsStadiumImage(Path<? extends TwinsStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTwinsStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTwinsStadiumImage(PathMetadata metadata, PathInits inits) {
        this(TwinsStadiumImage.class, metadata, inits);
    }

    public QTwinsStadiumImage(Class<? extends TwinsStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.twinsStadium = inits.isInitialized("twinsStadium") ? new QTwinsStadium(forProperty("twinsStadium"), inits.get("twinsStadium")) : null;
    }

}

