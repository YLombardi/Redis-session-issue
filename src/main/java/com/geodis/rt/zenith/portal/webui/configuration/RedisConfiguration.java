package com.geodis.rt.zenith.portal.webui.configuration;

import com.geodis.rt.zenith.portal.webui.authentication.LdapFailAwareRedisObjectSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import org.springframework.session.ExpiringSession;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    @Primary
    @Bean
    public RedisTemplate<Object,Object>
    redisTemplate(@Qualifier("jedisConnectionFactory") RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();

//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

//        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
//        template.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//        template.setHashValueSerializer(new JdkSerializationRedisSerializer());
//        template.setHashValueSerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(new LdapFailAwareRedisObjectSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        template.setConnectionFactory(connectionFactory);
        return template;
    }

    @Bean
    public RedisSerializer springSessionDefaultRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }
}