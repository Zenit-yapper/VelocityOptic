#version 150

uniform sampler2D DiffuseSampler;
varying vec2 texCoord;
uniform float BlurStrength; // This matches our variable

void main() {
    vec4 center = texture(DiffuseSampler, texCoord);
    vec4 blur = vec4(0.0);
    float samples = 10.0;
    
    // We multiply the spread by our variable from the GUI
    float spread = 0.005 * BlurStrength; 

    for(float i = 0.0; i < samples; i++) {
        blur += texture(DiffuseSampler, texCoord + vec2(i * spread, 0.0));
    }
    
    gl_FragColor = (center + (blur / samples)) / 2.0;
}
