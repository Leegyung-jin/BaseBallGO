package com.bbgo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStadiumImage is a Querydsl query type for StadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStadiumImage extends EntityPathBase<StadiumImage> {

    private static final long serialVersionUID = -1827538512L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStadiumImage stadiumImage = new QStadiumImage("stadiumImage");

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final StringPath path = createString("path");

    public final QStadium stadium;

    public final StringPath uuid = createString("uuid");

    public QStadiumImage(String variable) {
        this(StadiumImage.class, forVariable(variable), INITS);
    }

    public QStadiumImage(Path<? extends StadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStadiumImage(PathMetadata metadata, PathInits inits) {
        this(StadiumImage.class, metadata, inits);
    }

    public QStadiumImage(Class<? extends StadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.stadium = inits.isInitialized("stadium") ? new QStadium(forProperty("stadium"), inits.get("stadium")) : null;
    }

}

