#version 150

uniform sampler2D DiffuseSampler;
varying vec2 texCoord;

void main() {
    vec4 center = texture(DiffuseSampler, texCoord);
    vec4 blur = vec4(0.0);
    float samples = 10.0;
    float spread = 0.002; // Adjust for intensity

    for(float i = 0.0; i < samples; i++) {
        blur += texture(DiffuseSampler, texCoord + vec2(i * spread, 0.0));
    }
    
    gl_FragColor = (center + (blur / samples)) / 2.0;
}

