package com.bbgo.entity.stadium;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHeroesStadiumImage is a Querydsl query type for HeroesStadiumImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHeroesStadiumImage extends EntityPathBase<HeroesStadiumImage> {

    private static final long serialVersionUID = 1661964809L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHeroesStadiumImage heroesStadiumImage = new QHeroesStadiumImage("heroesStadiumImage");

    public final QHeroesStadium heroesStadium;

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> ino = createNumber("ino", Long.class);

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QHeroesStadiumImage(String variable) {
        this(HeroesStadiumImage.class, forVariable(variable), INITS);
    }

    public QHeroesStadiumImage(Path<? extends HeroesStadiumImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHeroesStadiumImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHeroesStadiumImage(PathMetadata metadata, PathInits inits) {
        this(HeroesStadiumImage.class, metadata, inits);
    }

    public QHeroesStadiumImage(Class<? extends HeroesStadiumImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.heroesStadium = inits.isInitialized("heroesStadium") ? new QHeroesStadium(forProperty("heroesStadium"), inits.get("heroesStadium")) : null;
    }

}

