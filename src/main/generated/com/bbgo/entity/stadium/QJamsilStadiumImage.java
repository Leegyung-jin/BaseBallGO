package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJamsilStadiumImage is a Querydsl query type for JamsilStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJamsilStadiumImage extends EntityPathBase<JamsilStadiumImage> {

    private static final long serialVersionUID = -1425921311L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJamsilStadiumImage jamsilStadiumImage = new QJamsilStadiumImage("jamsilStadiumImage");

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final QJamsilStadium jamsilStadium;

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QJamsilStadiumImage(String variable) {
        this(JamsilStadiumImage.class, forVariable(variable), INITS);
    }

    public QJamsilStadiumImage(Path<? extends JamsilStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJamsilStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJamsilStadiumImage(PathMetadata metadata, PathInits inits) {
        this(JamsilStadiumImage.class, metadata, inits);
    }

    public QJamsilStadiumImage(Class<? extends JamsilStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jamsilStadium = inits.isInitialized("jamsilStadium") ? new QJamsilStadium(forProperty("jamsilStadium"), inits.get("jamsilStadium")) : null;
    }

}

